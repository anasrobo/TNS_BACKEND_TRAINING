package com.tnsif.shoppingmall.controller;

import com.tnsif.shoppingmall.entity.Customer;
import com.tnsif.shoppingmall.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> get(@PathVariable int id) {
        Customer c = customerService.get(id);
        return c != null ? ResponseEntity.ok(c) : ResponseEntity.notFound().build();
    }
}
