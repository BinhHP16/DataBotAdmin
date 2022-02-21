package com.saltlux.botadmin.service;

import com.saltlux.botadmin.entity.CheckinEntity;

import java.util.List;

public interface ICheckinService {
    List<CheckinEntity> findByUserIdAndMonth(Integer userId, Integer month);

    List<CheckinEntity> findByUserIdAndMonthAndYearCheck(Integer userId, Integer month, Integer year);
}
