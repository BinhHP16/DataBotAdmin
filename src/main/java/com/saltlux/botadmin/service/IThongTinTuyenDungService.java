package com.saltlux.botadmin.service;

import com.saltlux.botadmin.entity.CategoryTuyenDungEntity;
import com.saltlux.botadmin.entity.ThongTinTuyenDungEntity;

import java.util.List;

public interface IThongTinTuyenDungService {


    List<ThongTinTuyenDungEntity> findByViTriCongViec(String viTri);


    List<CategoryTuyenDungEntity> getAll();
}
