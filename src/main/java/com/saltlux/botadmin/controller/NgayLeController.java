package com.saltlux.botadmin.controller;

import com.saltlux.botadmin.dto.ngayle.NgayLeDto;
import com.saltlux.botadmin.service.INgayLeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags = "Ngày lễ")
@RestController
@RequestMapping("/api/ngay_le")
public class NgayLeController {
   @Autowired
    INgayLeService service;

    @GetMapping("")
    public List<NgayLeDto> chiTietNgayLe(){
       return  service.chiTietNgayLe();
    }
}
