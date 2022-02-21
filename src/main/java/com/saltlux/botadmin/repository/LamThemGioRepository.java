package com.saltlux.botadmin.repository;

import com.saltlux.botadmin.entity.ChiTietNgayLeEntity;
import com.saltlux.botadmin.entity.LamThemGioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LamThemGioRepository extends JpaRepository<LamThemGioEntity, Integer> {
}
