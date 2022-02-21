package com.saltlux.botadmin.repository;

import com.saltlux.botadmin.entity.CategoryTuyenDungEntity;
import com.saltlux.botadmin.entity.ThongTinTuyenDungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThongTinTuyenDungRepository extends JpaRepository<ThongTinTuyenDungEntity, Integer> {
    @Query(value = "SELECT * FROM data_bot_admin.thong_tin_tuyen_dung where category_id in\n" +
            " (SELECT id from data_bot_admin.category_tuyen_dung a where a.vi_tri=:viTri)", nativeQuery = true)
    List<ThongTinTuyenDungEntity> findByViTri(String viTri);
}
