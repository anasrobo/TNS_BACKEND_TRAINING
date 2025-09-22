package com.tnsif.shoppingmall.services;

import com.tnsif.shoppingmall.entity.Employee;
import com.tnsif.shoppingmall.entity.Shop;
import com.tnsif.shoppingmall.entity.ShopOwner;
import com.tnsif.shoppingmall.repository.ShopRepository;
 import com.tnsif.shoppingmall.repository.ShopOwnerRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ShopService {

    private final ShopRepository shopRepository;
    private final ShopOwnerRepository ownerRepository;

    public ShopService(ShopRepository shopRepository, ShopOwnerRepository ownerRepository) {
        this.shopRepository = shopRepository;
        this.ownerRepository = ownerRepository;
    }

    @Transactional
    public Shop saveShop(Shop shop) {
        // ✅ Ensure relationships are set properly before persisting
        ShopOwner owner = shop.getShopOwner();
        if (owner != null) {
            owner.setShop(shop); // bidirectional fix
        }

        if (shop.getShopEmployeeID() != null) {
            for (Employee emp : shop.getShopEmployeeID()) {
                emp.setShop(shop); // link employee → shop
            }
        }

        // Save the shop first (generates shopId), then save owner referencing it
        Shop saved = shopRepository.save(shop);
        if (owner != null) {
            ownerRepository.save(owner);
        }
        return saved;
    }

    public Shop getShop(int id) {
        return shopRepository.findById(id).orElse(null);
    }
}
