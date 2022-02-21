package com.saltlux.botadmin.service;

import com.saltlux.botadmin.dto.congdoan.DongQuyCongDoanDto;
import com.saltlux.botadmin.dto.congdoan.UserDongQuyConvertDto;
import com.saltlux.botadmin.entity.DongQuyCongDoanEntity;
import com.saltlux.botadmin.entity.UserEntity;
import com.saltlux.botadmin.repository.DongQuyCongDoanRepository;
import com.saltlux.botadmin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DongQuyCongDoanService implements IDongQuyCongDoanService{

    @Autowired
    DongQuyCongDoanRepository repository;

    @Autowired
    UserRepository userRepository;

    @Override
    public List<DongQuyCongDoanEntity> findByUserIdAndYear(Integer userId, Integer year) {
        return repository.findByUserIdAndYear(userId,year);
    }

    @Override
    public Integer tongThu(Integer year) {
        List<UserEntity> listUser = userRepository.findAll();


        List<UserDongQuyConvertDto> listDongQuy = new ArrayList<>();
        int tongTien=0;
        for (UserEntity user : listUser) {
            List<DongQuyCongDoanDto> converts = new ArrayList<>();

            List<DongQuyCongDoanEntity> list=this.findByUserIdAndYear(user.getId(),year);
            for (DongQuyCongDoanEntity convert : list) {
                tongTien+=convert.getSoTien();
                DongQuyCongDoanDto dongQuy = new DongQuyCongDoanDto(convert.getId(),convert.getSoTien(),convert.getNgayDong(),convert.getNoiDung());
                converts.add(dongQuy);
            }

            UserDongQuyConvertDto dto = new UserDongQuyConvertDto(user.getId(), user.getHoTen(), user.getBoPhan(), user.getSdt(), user.getEmail(), converts);
            listDongQuy.add(dto);
        }
        return tongTien;
    }
}
