package com.saltlux.botadmin.service;

import com.saltlux.botadmin.dto.cacnoidung.ChiTietNoiDungDto;

import java.util.List;

public interface IChiTietNoiDungService {
    List<ChiTietNoiDungDto> findByCode(String code);
}
