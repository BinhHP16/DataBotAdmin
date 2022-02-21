package com.saltlux.botadmin.repository;

import com.saltlux.botadmin.entity.CategoryTuyenDungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryTuyenDungRepository extends JpaRepository<CategoryTuyenDungEntity, Integer> {
}
