package com.saltlux.botadmin.service;

import com.saltlux.botadmin.repository.NgayNghiPhepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NgayNghiPhepService implements INgayNghiPhepService{

    @Autowired
    NgayNghiPhepRepository repository;

    @Override
    public Double soNgayNghiPhep(Integer userId, Integer month, Integer year) {
        return repository.soNgayNghiPhep(userId, month, year);
    }
}
