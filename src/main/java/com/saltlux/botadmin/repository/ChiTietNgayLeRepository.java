package com.saltlux.botadmin.repository;

import com.saltlux.botadmin.entity.ChiTietNgayLeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietNgayLeRepository extends JpaRepository<ChiTietNgayLeEntity, Integer> {
}
