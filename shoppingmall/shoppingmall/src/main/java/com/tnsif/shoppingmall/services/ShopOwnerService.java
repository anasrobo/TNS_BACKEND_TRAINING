package com.tnsif.shoppingmall.services;

import org.springframework.stereotype.Service;

import com.tnsif.shoppingmall.entity.ShopOwner;
import com.tnsif.shoppingmall.repository.ShopOwnerRepository;

@Service
public class ShopOwnerService {

    private final ShopOwnerRepository shopOwnerRepository;

    public ShopOwnerService(ShopOwnerRepository shopOwnerRepository) {
        this.shopOwnerRepository = shopOwnerRepository;
    }

    public ShopOwner save(ShopOwner owner) {
        // Owning side is ShopOwner (has @JoinColumn on shop_id), so saving owner
        // will persist the relation to Shop if provided in payload.
        return shopOwnerRepository.save(owner);
    }

    public ShopOwner get(int id) {
        return shopOwnerRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        shopOwnerRepository.deleteById(id);
    }
}
