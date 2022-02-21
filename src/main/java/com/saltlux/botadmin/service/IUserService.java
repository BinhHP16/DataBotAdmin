package com.saltlux.botadmin.service;

import com.saltlux.botadmin.dto.UserDto;
import com.saltlux.botadmin.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserEntity> getAll();
    List<UserDto> finAll();

    UserEntity findByUserId(Integer userId);

    UserDto finById(Integer userId);

    UserEntity findByEmailAndPassword(String email, String password);




//    PagedResponse<UserEntity> getAll(int page, int size, String orderBy, String sortDirection);

}
