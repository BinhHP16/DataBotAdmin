package com.saltlux.botadmin.repository;

import com.saltlux.botadmin.dto.UserDto;
import com.saltlux.botadmin.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT s from UserEntity s")
    Page<UserEntity> search(Pageable pageable);

    @Query("SELECT s from UserEntity s where s.id=:userId")
    UserEntity findByUserId(@Param("userId") Integer userId);

    @Query(value = " SELECT * FROM data_bot_admin.user where user.password=:password and user.email=:email", nativeQuery = true)
    UserEntity findByEmailAndPassword(String email, String password);
}
