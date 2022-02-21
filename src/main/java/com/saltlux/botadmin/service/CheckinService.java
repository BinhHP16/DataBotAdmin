package com.saltlux.botadmin.service;

import com.saltlux.botadmin.entity.CheckinEntity;
import com.saltlux.botadmin.repository.CheckinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckinService implements ICheckinService{
    @Autowired
    CheckinRepository repository;

    @Override
    public List<CheckinEntity> findByUserIdAndMonth(Integer userId, Integer month) {
        return   repository.findByUserIdAndMonth(userId,month);
    }

    @Override
    public List<CheckinEntity> findByUserIdAndMonthAndYearCheck(Integer userId, Integer month, Integer year) {
        return repository.findByUserIdAndMonthAndYearCheck(userId, month, year);
    }
}
