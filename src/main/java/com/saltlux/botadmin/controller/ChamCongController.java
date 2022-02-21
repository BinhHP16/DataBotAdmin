package com.saltlux.botadmin.controller;

import com.saltlux.botadmin.dto.chamcong.ChamCongDto;
import com.saltlux.botadmin.dto.chamcong.ChiTietDiMuonDto;
import com.saltlux.botadmin.dto.chamcong.UserCheckinConvertDto;
import com.saltlux.botadmin.dto.ngaynghiphep.NgayNghiPhepConvertDto;
import com.saltlux.botadmin.dto.ngaynghiphep.UserNgayNghiPhepDto;
import com.saltlux.botadmin.entity.CheckinEntity;
import com.saltlux.botadmin.entity.NgayNghiPhepEntity;
import com.saltlux.botadmin.entity.UserEntity;
import com.saltlux.botadmin.service.ICheckinService;
import com.saltlux.botadmin.service.INgayNghiPhepService;
import com.saltlux.botadmin.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Api(tags = "Chấm công")
@RestController
@RequestMapping("/api/cham_cong")
public class ChamCongController {

    @Autowired
    IUserService service;

    @Autowired
    ICheckinService serviceCheckin;

    @Autowired
    INgayNghiPhepService ngayNghiPhepService;

    @GetMapping("/ngay_nghi_phep")
    public List<UserNgayNghiPhepDto> getAll() {
        List<UserEntity> listUser = service.getAll();
        List<UserNgayNghiPhepDto> listNgayNghiPhep = new ArrayList<>();
        for (UserEntity user : listUser) {
            List<NgayNghiPhepConvertDto> converts = new ArrayList<>();
            Double count = 0.0;
            for (NgayNghiPhepEntity convert : user.getListNgayNghiPhep()) {
                NgayNghiPhepConvertDto ngayNghi = new NgayNghiPhepConvertDto(convert.getId(), convert.getNgayNghiPhep(), convert.getManDay());
                converts.add(ngayNghi);
                count += convert.getManDay();
            }

            UserNgayNghiPhepDto dto = new UserNgayNghiPhepDto(user.getId(), user.getHoTen(), user.getSoNgayNghiPhepTieuChuan(), user.getBoPhan(), converts, count, (user.getSoNgayNghiPhepTieuChuan() - count));
            listNgayNghiPhep.add(dto);
        }

        return listNgayNghiPhep;
    }

    @GetMapping("/ngay_nghi_phep/{userId}")
    public UserNgayNghiPhepDto ngayNghiPhepUser(@PathVariable(name = "userId") Integer userId) {
        UserEntity user = service.findByUserId(userId);

        List<NgayNghiPhepConvertDto> converts = new ArrayList<>();
        Double count = 0.0;
        for (NgayNghiPhepEntity convert : user.getListNgayNghiPhep()) {
            NgayNghiPhepConvertDto ngayNghi = new NgayNghiPhepConvertDto(convert.getId(), convert.getNgayNghiPhep(), convert.getManDay());
            converts.add(ngayNghi);
            count += convert.getManDay();
        }

        UserNgayNghiPhepDto dto = new UserNgayNghiPhepDto(user.getId(), user.getHoTen(), user.getSoNgayNghiPhepTieuChuan(), user.getBoPhan(), converts, count, (user.getSoNgayNghiPhepTieuChuan() - count));
        return dto;
    }

    @GetMapping("/checkin")
    public List<UserCheckinConvertDto> checkin() {
        List<UserEntity> listUser = service.getAll();
        List<UserCheckinConvertDto> listCheckin = new ArrayList<>();
        for (UserEntity user : listUser) {
            List<Date> converts = new ArrayList<>();

            for (CheckinEntity convert : user.getListCheckin()) {

                converts.add(convert.getThoiGianCheckIn());
            }
            UserCheckinConvertDto dto = new UserCheckinConvertDto(user.getId(), user.getHoTen(), user.getBoPhan(), user.getSdt(), user.getEmail(), converts);
            listCheckin.add(dto);
        }

        return listCheckin;
    }


    @GetMapping("/checkin/{userId}")
    public UserCheckinConvertDto chiTietCheckin(@PathVariable(name = "userId") Integer userId, @RequestParam Integer month) {
        UserEntity user = service.findByUserId(userId);

        List<CheckinEntity> checkins = serviceCheckin.findByUserIdAndMonth(userId, month);


        List<Date> converts = new ArrayList<>();

        for (CheckinEntity convert : checkins) {
//            if(convert.getThoiGianCheckIn()>thoiGianLamViecQuyDinh && convert.getThoiGianCheckIn().getDate()==month){
//            converts.add(convert.getThoiGianCheckIn());
//        }
            converts.add(convert.getThoiGianCheckIn());

        }

        UserCheckinConvertDto dto = new UserCheckinConvertDto(user.getId(), user.getHoTen(), user.getBoPhan(), user.getSdt(), user.getEmail(), converts);
        return dto;
    }

    @GetMapping("/{userId}")
    public ChamCongDto chamCong(@PathVariable(name = "userId") Integer userId, @RequestParam Integer month, @RequestParam Integer year, @RequestParam long ngayCongDuKien) {
        UserEntity user = service.findByUserId(userId);
        String userName = user.getHoTen();
        String thoiGian = "" + month + "/" + year;
        Double soNgayNghiPhep = ngayNghiPhepService.soNgayNghiPhep(userId, month, year);
        if (soNgayNghiPhep == null) {
            soNgayNghiPhep = 0.0;
        }
        List<CheckinEntity> listCheckin = serviceCheckin.findByUserIdAndMonthAndYearCheck(userId, month, year);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String thoiGianLamViecQuyDinh = " 08:00:00";
        long hours = 0;
        long minutes = 0;
        for (CheckinEntity entity : listCheckin) {
            Date d1 = null;
            Date d2 = null;
            try {
                d1 = format.parse(thoiGianLamViecQuyDinh);
                d2 = format.parse(entity.getThoiGianCheckIn().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (d2.getTime() > d1.getTime()) {
                // Get msec from each, and subtract.
                long diff = d2.getTime() - d1.getTime();
                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000);
                hours += diffHours;
                minutes += diffMinutes;
            }

        }
        long tongThoiGian = hours * 60 + minutes;
        long tongThoiGianDiMuon = tongThoiGian;
        long ngayDiMuon = 0;

        while (tongThoiGianDiMuon > 240) {
            tongThoiGianDiMuon = tongThoiGianDiMuon % 240;
            ngayDiMuon += 0.5;

        }

        double ngayCongThucTe = ngayCongDuKien - soNgayNghiPhep - ngayDiMuon;


        ChamCongDto chamCong = new ChamCongDto(userName, thoiGian, soNgayNghiPhep, tongThoiGian, ngayCongThucTe);
        return chamCong;
    }

    @GetMapping("/chi_tiet_di_muon/{userId}")
    public List<ChiTietDiMuonDto> chiTietDiMuon(@PathVariable(name = "userId") Integer userId, @RequestParam Integer month, @RequestParam Integer year) {

        String thoiGian = "" + month + "/" + year;

        List<CheckinEntity> listCheckin = serviceCheckin.findByUserIdAndMonthAndYearCheck(userId, month, year);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String thoiGianLamViecQuyDinh = " 08:00:00";

        List<ChiTietDiMuonDto> list = new ArrayList<>();
        for (CheckinEntity entity : listCheckin) {
            Date d1 = null;
            Date d2 = null;
            try {
                d1 = format.parse(thoiGianLamViecQuyDinh);
                d2 = format.parse(entity.getThoiGianCheckIn().toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (d2.getTime() > d1.getTime()) {
                // Get msec from each, and subtract.
                long diff = d2.getTime() - d1.getTime();
                long diffSeconds = diff / 1000 % 60;
                long diffMinutes = diff / (60 * 1000) % 60;
                long diffHours = diff / (60 * 60 * 1000);
                long minutes = diffHours * 60 + diffMinutes;

                ChiTietDiMuonDto chiTietDiMuonDto = new ChiTietDiMuonDto(thoiGian, entity.getNgayCheckIn(), minutes);
                list.add(chiTietDiMuonDto);
            }

        }
        return list;
    }

}
