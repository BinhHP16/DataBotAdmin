package com.saltlux.botadmin.service;

import com.saltlux.botadmin.dto.UserDto;
import com.saltlux.botadmin.dto.congdoan.UserDongQuyConvertDto;
import com.saltlux.botadmin.entity.UserEntity;
import com.saltlux.botadmin.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository repository;

    @Override
    public List<UserEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public List<UserDto> finAll() {
        List<UserDto> dtos=new ArrayList<>();
        List<UserEntity> listUsers=repository.findAll();
        for (UserEntity user : listUsers) {
            UserDto dto =new UserDto(user.getId(),user.getHoTen(),user.getBoPhan(),user.getGioiTinh(),
                    user.getNgaySinh(),user.getSdt(),user.getEmail(),user.getSoNgayNghiPhepTieuChuan());
            dtos.add(dto);
        }


        return dtos;
    }

    @Override
    public UserEntity findByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public UserDto finById(Integer userId) {
        UserEntity user =repository.findByUserId(userId);
        UserDto dto =new UserDto(user.getId(),user.getHoTen(),user.getBoPhan(),user.getGioiTinh(),
                user.getNgaySinh(),user.getSdt(),user.getEmail(),user.getSoNgayNghiPhepTieuChuan());

        return dto;
    }

    @Override
    public UserEntity findByEmailAndPassword(String email, String password) {

       return repository.findByEmailAndPassword(email,password);

    }



//    @Override
//    public PagedResponse<UserEntity> getAll(int page, int size, String orderBy, String sortDirection) {
//        Pageable pageable = buildPageable(page, size,orderBy,  sortDirection);
//        Page<UserEntity> systemPage = repository.search(pageable);
//        List<UserEntity> listChucNang = systemPage.getContent();
//        return new PagedResponse<>(listChucNang, systemPage.getNumber(), systemPage.getSize(), systemPage.getTotalElements(),
//                systemPage.getTotalPages(), systemPage.isLast());
//    }
}
