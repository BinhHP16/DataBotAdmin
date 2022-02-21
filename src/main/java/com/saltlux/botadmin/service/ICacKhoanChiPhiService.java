package com.saltlux.botadmin.service;

import com.saltlux.botadmin.dto.congdoan.CacKhoanChiPhiDto;

import java.util.List;

public interface ICacKhoanChiPhiService {
    List<CacKhoanChiPhiDto> chiQuy(Integer year );

   Integer tongChi(Integer year);
}
