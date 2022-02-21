package com.saltlux.botadmin.repository;

import com.saltlux.botadmin.entity.ChiTietNoiDungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ChiTietNoiDungRepository extends JpaRepository<ChiTietNoiDungEntity, Integer> {
    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM data_bot_admin.chi_tiet_noi_dung where noi_dung_chung_id in " +
            "(SELECT s.id from data_bot_admin.noi_dung_chung s  where s.code=:code)", nativeQuery = true)
    List<ChiTietNoiDungEntity> findByCode(@Param("code") String code);
}
