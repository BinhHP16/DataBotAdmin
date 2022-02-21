package com.saltlux.botadmin.controller;

import com.saltlux.botadmin.dto.cacnoidung.ChiTietNoiDungDto;
import com.saltlux.botadmin.dto.cacnoidung.NoiDungChungDto;
import com.saltlux.botadmin.service.IChiTietNoiDungService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@Api(tags = "Các nội dung")
@RestController
@RequestMapping("/api/noi_dung")
public class ChiTietCacNoiDungController {

    @Autowired
    IChiTietNoiDungService chiTietNoiDungService;

    @GetMapping("/")
    public List<NoiDungChungDto> noiDungChung(){
        List list =new ArrayList();
        NoiDungChungDto dto1=new NoiDungChungDto(1,"Phúc lợi","Sức Khỏe","SUC KHOE");
        NoiDungChungDto dto2=new NoiDungChungDto(2,"Phúc lợi","Cá nhân","CA NHAN");
        list.add(dto1);
        list.add(dto2);
        return list;
    }

    @GetMapping("/{code}")
    public List<ChiTietNoiDungDto> chiTietNoiDung(@PathVariable String code){
      return chiTietNoiDungService.findByCode(code);
    }
}
