package com.tnsif.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.shoppingmall.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {
}
