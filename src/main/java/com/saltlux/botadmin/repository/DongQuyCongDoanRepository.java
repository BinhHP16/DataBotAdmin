package com.saltlux.botadmin.repository;

import com.saltlux.botadmin.entity.DongQuyCongDoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DongQuyCongDoanRepository extends JpaRepository<DongQuyCongDoanEntity, Integer> {

    @Query(value = "SELECT * FROM data_bot_admin.dong_quy_cong_doan where user_id=:userId and year(ngay_dong)=:year",nativeQuery = true)
    List<DongQuyCongDoanEntity> findByUserIdAndYear(Integer userId, Integer year);
}
