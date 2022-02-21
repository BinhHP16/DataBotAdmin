package com.saltlux.botadmin.service;

import com.saltlux.botadmin.dto.cacnoidung.ChiTietNoiDungDto;
import com.saltlux.botadmin.entity.ChiTietNoiDungEntity;
import com.saltlux.botadmin.repository.ChiTietNoiDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChiTietNoiDungService implements IChiTietNoiDungService{

    @Autowired
    ChiTietNoiDungRepository repository;

    @Override
    public List<ChiTietNoiDungDto> findByCode(String code) {
      List<ChiTietNoiDungDto> dtos=new ArrayList<>();
      List<ChiTietNoiDungEntity> list= repository.findByCode(code);
      for(ChiTietNoiDungEntity chiTietNoiDung : list){
          ChiTietNoiDungDto dto=new ChiTietNoiDungDto(chiTietNoiDung.getId(),chiTietNoiDung.getTieuDe(),
                  chiTietNoiDung.getThongTinChiTiet(),chiTietNoiDung.getGhiChu());
          dtos.add(dto);

      }
        return dtos;
    }
}
