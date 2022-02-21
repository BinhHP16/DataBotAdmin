package com.saltlux.botadmin.repository;

import com.saltlux.botadmin.entity.CheckinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CheckinRepository extends JpaRepository<CheckinEntity, Integer> {
    @Query(value = "SELECT * FROM data_bot_admin.check_in where data_bot_admin.check_in.user_id=:userId" +
            " and month(thoi_gian_check_in)=:month", nativeQuery = true)
    List<CheckinEntity> findByUserIdAndMonth(@Param("userId") Integer userId, @Param("month") Integer month);


    @Query(value = "SELECT * FROM data_bot_admin.check_in where user_id=:userId " +
            "and month(ngay_check_in)=:month and year(ngay_check_in)=:year", nativeQuery = true)
    List<CheckinEntity> findByUserIdAndMonthAndYearCheck(@Param("userId")Integer userId, @Param("month")Integer month, @Param("year")Integer year);



}
