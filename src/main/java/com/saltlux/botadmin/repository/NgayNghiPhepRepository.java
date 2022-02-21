package com.saltlux.botadmin.repository;

import com.saltlux.botadmin.entity.NgayNghiPhepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NgayNghiPhepRepository extends JpaRepository<NgayNghiPhepEntity, Integer> {

    @Query(value = "SELECT sum(man_day) FROM data_bot_admin.ngay_nghi_phep " +
            "where month(ngay_nghi_phep)=:month " +
            "and year(ngay_nghi_phep)=:year and user_id=:userId",nativeQuery = true)
    Double soNgayNghiPhep(Integer userId, Integer month, Integer year);
}
