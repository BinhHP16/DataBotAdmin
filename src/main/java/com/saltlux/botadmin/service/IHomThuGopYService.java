package com.saltlux.botadmin.service;

import com.saltlux.botadmin.entity.HomThuGopYEntity;
import com.saltlux.botadmin.payload.HomThuGopYReq;
import org.springframework.web.bind.MissingServletRequestParameterException;

public interface IHomThuGopYService {
    HomThuGopYEntity saveHomThuGopY(HomThuGopYReq request) throws MissingServletRequestParameterException;
}
