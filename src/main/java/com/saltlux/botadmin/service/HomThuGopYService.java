package com.saltlux.botadmin.service;

import com.saltlux.botadmin.entity.HomThuGopYEntity;
import com.saltlux.botadmin.payload.HomThuGopYReq;
import com.saltlux.botadmin.repository.HomThuGopYRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MissingServletRequestParameterException;

import static com.saltlux.botadmin.utils.ValidationUtil.isValidId;

@Log4j2
@Service
public class HomThuGopYService implements IHomThuGopYService{

    @Autowired
    HomThuGopYRepository repository;

    @Override
    public HomThuGopYEntity saveHomThuGopY(HomThuGopYReq request) throws MissingServletRequestParameterException {
        log.info("start save hòm thư góp ý ");
        if (request == null) {
            throw new MissingServletRequestParameterException(null, null);
        }
        Integer id = request.getId();
        HomThuGopYEntity system = isValidId(id) ? repository.findById(id).get() : new HomThuGopYEntity();
//        request.setStatus(AppConstants.STATUS_ACTIVE);
//        request.setCreatedDate(new java.util.Date());
//        request.setUpdatedDate(new java.util.Date());
        BeanUtils.copyProperties(request, system, "hòm thư góp ý");

        return repository.save(system);
    }
}
