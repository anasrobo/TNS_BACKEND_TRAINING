package com.tnsif.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.shoppingmall.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
}
