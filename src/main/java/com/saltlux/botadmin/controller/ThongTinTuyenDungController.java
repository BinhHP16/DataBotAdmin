package com.saltlux.botadmin.controller;

import com.saltlux.botadmin.dto.tuyendung.ThongTinTuyenDungDto;
import com.saltlux.botadmin.entity.CategoryTuyenDungEntity;
import com.saltlux.botadmin.entity.ThongTinTuyenDungEntity;
import com.saltlux.botadmin.service.IThongTinTuyenDungService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "Tuyển dụng")
@RestController
@RequestMapping("/api/tuyen_dung")
public class ThongTinTuyenDungController {

    @Autowired
    private IThongTinTuyenDungService service;

    @GetMapping("/")
    public List<CategoryTuyenDungEntity> getCategory(){

        return service.getAll();
    }

    @GetMapping("/chi_tiet")
    public List<ThongTinTuyenDungDto> findByViTriCongViec(@RequestParam String viTri){

        List<ThongTinTuyenDungDto> dtos=new ArrayList<>();
        List<ThongTinTuyenDungEntity> entities =service.findByViTriCongViec(viTri);
        for (ThongTinTuyenDungEntity entity : entities) {
            ThongTinTuyenDungDto dto=new ThongTinTuyenDungDto(entity.getId(),entity.getTieuDe(),entity.getNoiDung());
       dtos.add(dto);
        }

        return dtos;

    }
}
