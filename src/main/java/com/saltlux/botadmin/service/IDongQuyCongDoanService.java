package com.saltlux.botadmin.service;

import com.saltlux.botadmin.entity.DongQuyCongDoanEntity;

import java.util.List;

public interface IDongQuyCongDoanService {
    List<DongQuyCongDoanEntity> findByUserIdAndYear(Integer userId, Integer year);

    Integer tongThu(Integer year);
}
