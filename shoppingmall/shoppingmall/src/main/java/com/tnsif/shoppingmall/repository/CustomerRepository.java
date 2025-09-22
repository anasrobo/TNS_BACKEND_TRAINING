package com.tnsif.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.shoppingmall.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
