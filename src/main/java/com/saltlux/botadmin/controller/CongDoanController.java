package com.saltlux.botadmin.controller;

import com.saltlux.botadmin.dto.congdoan.CacKhoanChiPhiDto;
import com.saltlux.botadmin.dto.congdoan.DongQuyCongDoanDto;
import com.saltlux.botadmin.dto.congdoan.TongHopThuChiDto;
import com.saltlux.botadmin.dto.congdoan.UserDongQuyConvertDto;
import com.saltlux.botadmin.entity.DongQuyCongDoanEntity;
import com.saltlux.botadmin.entity.HomThuGopYEntity;
import com.saltlux.botadmin.entity.UserEntity;
import com.saltlux.botadmin.exception.DuplicatedColumnsException;
import com.saltlux.botadmin.payload.HomThuGopYReq;
import com.saltlux.botadmin.service.ICacKhoanChiPhiService;
import com.saltlux.botadmin.service.IDongQuyCongDoanService;
import com.saltlux.botadmin.service.IHomThuGopYService;
import com.saltlux.botadmin.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags = "Công đoàn")
@RequestMapping("/api/cong_doan")
public class CongDoanController {

    @Autowired
    IUserService service;

    @Autowired
    IHomThuGopYService homThuGopYService;

    @Autowired
    ICacKhoanChiPhiService chiPhiService;

    @Autowired
    IDongQuyCongDoanService dongQuyCongDoanService;

    @GetMapping("/thu")
    public List<UserDongQuyConvertDto> dongQuy(Integer year) {
        List<UserEntity> listUser = service.getAll();


        List<UserDongQuyConvertDto> listDongQuy = new ArrayList<>();
        int tongTien=0;
        for (UserEntity user : listUser) {
            List<DongQuyCongDoanDto> converts = new ArrayList<>();

            List<DongQuyCongDoanEntity> list=dongQuyCongDoanService.findByUserIdAndYear(user.getId(),year);
            for (DongQuyCongDoanEntity convert : list) {
                tongTien+=convert.getSoTien();
                DongQuyCongDoanDto dongQuy = new DongQuyCongDoanDto(convert.getId(),convert.getSoTien(),convert.getNgayDong(),convert.getNoiDung());
                converts.add(dongQuy);
            }

            UserDongQuyConvertDto dto = new UserDongQuyConvertDto(user.getId(), user.getHoTen(), user.getBoPhan(), user.getSdt(), user.getEmail(), converts);
            listDongQuy.add(dto);
        }

        return listDongQuy;
    }

    @GetMapping("/thu/tong_tien_thu")
    public Integer tongTien(Integer year) {

        return dongQuyCongDoanService.tongThu(year);
    }

    @GetMapping("/thu/{userId}")
    public UserDongQuyConvertDto chiTietTungNguoi(@PathVariable Integer userId, @RequestParam Integer year) {
        UserEntity user = service.findByUserId(userId);
        List<DongQuyCongDoanEntity> list=dongQuyCongDoanService.findByUserIdAndYear(userId,year);


        List<DongQuyCongDoanDto> converts = new ArrayList<>();

        int tongTien=0;
        for (DongQuyCongDoanEntity convert : list) {
            tongTien+=convert.getSoTien();
            DongQuyCongDoanDto dongQuy = new DongQuyCongDoanDto(convert.getId(),convert.getSoTien(),convert.getNgayDong(),convert.getNoiDung());
            converts.add(dongQuy);
        }

        UserDongQuyConvertDto dto = new UserDongQuyConvertDto(user.getId(),
                user.getHoTen(), user.getBoPhan(), user.getSdt(), user.getEmail(),tongTien, converts);


        return dto;
    }

    @GetMapping("/chi")
    public List<CacKhoanChiPhiDto> chiQuy(@RequestParam Integer year) {

      return chiPhiService.chiQuy(year);
    }

    @GetMapping("/chi/tong_chi")
    public Integer tongChi(@RequestParam Integer year) {

        return chiPhiService.tongChi(year);
    }

    @PostMapping("/hom_thu_gop_y")
    public HomThuGopYEntity save(@Valid @RequestBody HomThuGopYReq request) throws MissingServletRequestParameterException, InvocationTargetException, NoSuchMethodException, DuplicatedColumnsException, IllegalAccessException {
        if (request == null) {
            throw new MissingServletRequestParameterException(null, null);
        }
        return homThuGopYService.saveHomThuGopY(request);
    }

    @GetMapping("/tong_hop_thu_chi")
    public TongHopThuChiDto tongHopThuChi(@RequestParam Integer year) {
       Integer tongThuNamTruoc= dongQuyCongDoanService.tongThu(year-1);
       Integer tongChiNamTruoc= chiPhiService.tongChi(year-1);
       Integer soDuDauNam=tongThuNamTruoc-tongChiNamTruoc;
        Integer khoanThu= dongQuyCongDoanService.tongThu(year);
        Integer khoanChi=chiPhiService.tongChi(year);
        TongHopThuChiDto dto=new TongHopThuChiDto(soDuDauNam,khoanThu,khoanChi);
        return dto;
    }

}
