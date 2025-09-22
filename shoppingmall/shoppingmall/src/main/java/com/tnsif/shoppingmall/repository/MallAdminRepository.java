package com.tnsif.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.shoppingmall.entity.MallAdmin;

public interface MallAdminRepository extends JpaRepository<MallAdmin, Integer> {
}
