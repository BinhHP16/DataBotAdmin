package com.saltlux.botadmin.controller;

import com.saltlux.botadmin.dto.lamthemgio.UserLamThemGioDto;
import com.saltlux.botadmin.service.ILamThemGioService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Làm thêm giờ")
@RestController
@RequestMapping("/api/lam_them_gio")
public class LamThemGioController {

    @Autowired
    ILamThemGioService service;

    @GetMapping("/{userId}")
    public UserLamThemGioDto lamThemGio(@PathVariable Integer userId){
       return service.lamThemGio(userId);
    }

    @GetMapping("/tinh_thu_nhap_chiu_thue")
    public Double lamThemGio(@RequestParam Double soGiolamThemNgayThuong, @RequestParam Double soGiolamThemNgayThu7Tuan1,
                             @RequestParam Double soGiolamThemNgayThu7Tuan2, @RequestParam Double soGiolamThemNgayThu7Tuan3,
                             @RequestParam Double soGiolamThemNgayThu7Tuan4, @RequestParam Double soGiolamThemNgayCN,
                             @RequestParam Double soGiolamThemNgayLe, @RequestParam Integer tienCong1Gio){

        return tienCong1Gio*(soGiolamThemNgayThuong*0.5+soGiolamThemNgayThu7Tuan1+soGiolamThemNgayThu7Tuan2+
                soGiolamThemNgayThu7Tuan3+soGiolamThemNgayThu7Tuan4+soGiolamThemNgayCN+
                soGiolamThemNgayLe*2);
    }



}
