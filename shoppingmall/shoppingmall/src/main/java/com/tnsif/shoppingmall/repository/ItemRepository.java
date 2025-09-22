package com.tnsif.shoppingmall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tnsif.shoppingmall.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
