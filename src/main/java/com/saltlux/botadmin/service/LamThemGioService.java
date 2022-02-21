package com.saltlux.botadmin.service;

import com.saltlux.botadmin.dto.lamthemgio.LamThemGioConvertDto;
import com.saltlux.botadmin.dto.lamthemgio.UserLamThemGioDto;
import com.saltlux.botadmin.entity.LamThemGioEntity;
import com.saltlux.botadmin.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LamThemGioService implements ILamThemGioService{
    @Autowired
    IUserService service;

    @Override
    public UserLamThemGioDto lamThemGio(Integer userId) {
        UserEntity user=service.findByUserId(userId);

        List<LamThemGioConvertDto> converts=new ArrayList<>();

        for (LamThemGioEntity convert :user.getListLamThemGio()){
            LamThemGioConvertDto lamThem = new LamThemGioConvertDto(convert.getId(),convert.getTieuDe(),convert.getGhiChu(),convert.getDate()
                    ,convert.getGioBatDau(),convert.getGioKetThuc());
            converts.add(lamThem);

        }
        UserLamThemGioDto dto =new UserLamThemGioDto(user.getId(),user.getHoTen(),user.getBoPhan(),converts);

        return dto;
    }
}
