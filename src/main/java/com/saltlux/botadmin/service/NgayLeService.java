package com.saltlux.botadmin.service;

import com.saltlux.botadmin.dto.ngayle.NgayLeDto;
import com.saltlux.botadmin.entity.ChiTietNgayLeEntity;
import com.saltlux.botadmin.entity.NgayLeEntity;
import com.saltlux.botadmin.repository.NgayLeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NgayLeService implements INgayLeService{
    @Autowired
    NgayLeRepository repository;
    @Override
    public List<NgayLeDto> chiTietNgayLe() {
        List<NgayLeEntity> list=new ArrayList();
        List<NgayLeDto> dtos=new ArrayList();

        list=repository.findAll();
        for (NgayLeEntity list1 : list) {


            List list2=new ArrayList();
            for (ChiTietNgayLeEntity ct : list1.getListThoiGianNgayLe()) {
                list2.add(ct.getDate());
            }
            NgayLeDto dto=new NgayLeDto(list1.getId(),list1.getTenNgayLe(),list1.getGhiChu(),list2);
            dtos.add(dto);
        }
        return dtos;

    }
}
