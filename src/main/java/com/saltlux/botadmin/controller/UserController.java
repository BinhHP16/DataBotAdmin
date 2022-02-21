package com.saltlux.botadmin.controller;

import com.saltlux.botadmin.dto.UserDto;
import com.saltlux.botadmin.entity.UserEntity;
import com.saltlux.botadmin.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "User")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    IUserService service;

    @GetMapping("/all")
    public List<UserDto> getAll() {

        return service.finAll();
    }

    @GetMapping("/{userId}")
    public UserDto finById(@PathVariable Integer userId) {

        return service.finById(userId);
    }

    @GetMapping("/log_in")
    public Integer Login(@RequestParam String email, @RequestParam String password) {

        UserEntity user =service.findByEmailAndPassword(email, password);
        if (user!=null) {
            System.out.println( "Login thành công");
            return user.getId();
        } else {
            System.out.println( "Login thất bại");
            return 0;
        }
    }
}

