package com.tnsif.shoppingmall.controller;



import com.tnsif.shoppingmall.entity.Shop;
import com.tnsif.shoppingmall.services.ShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    // ✅ Create Shop (with owner + employees in one go)
    @PostMapping
    public ResponseEntity<Shop> createShop(@RequestBody Shop shop) {
        Shop savedShop = shopService.saveShop(shop);
        return ResponseEntity.ok(savedShop);
    }

    // ✅ Get Shop by ID
    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShop(@PathVariable int id) {
        Shop shop = shopService.getShop(id);
        if (shop != null) {
            return ResponseEntity.ok(shop);
        }
        return ResponseEntity.notFound().build();
    }
}
