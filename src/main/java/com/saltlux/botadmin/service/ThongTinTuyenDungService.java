package com.saltlux.botadmin.service;

import com.saltlux.botadmin.entity.CategoryTuyenDungEntity;
import com.saltlux.botadmin.entity.ThongTinTuyenDungEntity;
import com.saltlux.botadmin.repository.CategoryTuyenDungRepository;
import com.saltlux.botadmin.repository.ThongTinTuyenDungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThongTinTuyenDungService implements IThongTinTuyenDungService {
    @Autowired
    ThongTinTuyenDungRepository repository;

    @Autowired
    CategoryTuyenDungRepository categoryTuyenDungRepository;


//    @Override
//    public List<CategoryTuyenDungEntity> getAll() {
//        return categoryTuyenDungRepository.findAll();
//    }

    @Override
    public List<ThongTinTuyenDungEntity> findByViTriCongViec(String viTri) {
        return repository.findByViTri(viTri);
    }

    @Override
    public List<CategoryTuyenDungEntity> getAll() {
        return categoryTuyenDungRepository.findAll();
    }

}
