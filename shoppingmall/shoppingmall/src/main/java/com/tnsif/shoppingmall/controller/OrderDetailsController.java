package com.tnsif.shoppingmall.controller;

import com.tnsif.shoppingmall.entity.OrderDetails;
import com.tnsif.shoppingmall.services.OrderDetailsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;

    public OrderDetailsController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @PostMapping
    public ResponseEntity<OrderDetails> create(@RequestBody OrderDetails order) {
        return ResponseEntity.ok(orderDetailsService.save(order));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetails> get(@PathVariable int id) {
        OrderDetails o = orderDetailsService.get(id);
        return o != null ? ResponseEntity.ok(o) : ResponseEntity.notFound().build();
    }
}
