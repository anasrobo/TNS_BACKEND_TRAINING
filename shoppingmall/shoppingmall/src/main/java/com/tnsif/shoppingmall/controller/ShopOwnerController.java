package com.tnsif.shoppingmall.controller;

import com.tnsif.shoppingmall.entity.ShopOwner;
import com.tnsif.shoppingmall.services.ShopOwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop-owners")
public class ShopOwnerController {

    private final ShopOwnerService shopOwnerService;

    public ShopOwnerController(ShopOwnerService shopOwnerService) {
        this.shopOwnerService = shopOwnerService;
    }

    // Create ShopOwner
    @PostMapping
    public ResponseEntity<ShopOwner> create(@RequestBody ShopOwner owner) {
        return ResponseEntity.ok(shopOwnerService.save(owner));
    }

    // Get ShopOwner by ID
    @GetMapping("/{id}")
    public ResponseEntity<ShopOwner> get(@PathVariable int id) {
        ShopOwner owner = shopOwnerService.get(id);
        return owner != null ? ResponseEntity.ok(owner) : ResponseEntity.notFound().build();
    }

    // Delete ShopOwner by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        shopOwnerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
