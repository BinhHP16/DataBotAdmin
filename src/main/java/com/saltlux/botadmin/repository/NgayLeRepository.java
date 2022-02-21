package com.saltlux.botadmin.repository;

import com.saltlux.botadmin.entity.NgayLeEntity;
import com.saltlux.botadmin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgayLeRepository extends JpaRepository<NgayLeEntity, Integer> {
}
