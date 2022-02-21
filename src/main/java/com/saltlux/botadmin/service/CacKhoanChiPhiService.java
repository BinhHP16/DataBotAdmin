package com.saltlux.botadmin.service;

import com.saltlux.botadmin.dto.congdoan.CacKhoanChiPhiDto;
import com.saltlux.botadmin.entity.CacKhoanChiPhiEntity;
import com.saltlux.botadmin.repository.CacKhoanChiPhiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CacKhoanChiPhiService implements ICacKhoanChiPhiService {

    @Autowired
    CacKhoanChiPhiRepository repository;

    @Override
    public List<CacKhoanChiPhiDto> chiQuy(Integer year) {
        List<CacKhoanChiPhiEntity> list=repository.findByYear(year);
        List<CacKhoanChiPhiDto> dtos=new ArrayList<>();
        int tongChi=0;
        for (CacKhoanChiPhiEntity chiPhi:list) {
            tongChi+=chiPhi.getSoTien();

                CacKhoanChiPhiDto dto=new CacKhoanChiPhiDto(chiPhi.getId(),chiPhi.getNoiDung(),chiPhi.getSoTien(),chiPhi.getThoiGian(),chiPhi.getGhiChu());
                dtos.add(dto);


        }
        return dtos;
    }

    @Override
    public Integer tongChi(Integer year) {
        List<CacKhoanChiPhiEntity> list=repository.findByYear(year);
        List<CacKhoanChiPhiDto> dtos=new ArrayList<>();
        int tongChi=0;
        for (CacKhoanChiPhiEntity chiPhi:list) {
            tongChi+=chiPhi.getSoTien();

            CacKhoanChiPhiDto dto=new CacKhoanChiPhiDto(chiPhi.getId(),chiPhi.getNoiDung(),chiPhi.getSoTien(),chiPhi.getThoiGian(),chiPhi.getGhiChu());
            dtos.add(dto);


        }
        return tongChi;
    }
}
