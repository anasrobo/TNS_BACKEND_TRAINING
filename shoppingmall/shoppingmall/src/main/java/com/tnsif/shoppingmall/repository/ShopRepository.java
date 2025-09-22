package com.tnsif.shoppingmall.repository;

import com.tnsif.shoppingmall.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
}
