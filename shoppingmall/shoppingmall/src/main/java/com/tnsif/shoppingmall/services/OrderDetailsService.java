package com.tnsif.shoppingmall.services;

import org.springframework.stereotype.Service;

import com.tnsif.shoppingmall.entity.OrderDetails;
import com.tnsif.shoppingmall.repository.OrderDetailsRepository;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public OrderDetails save(OrderDetails order) {
        return orderDetailsRepository.save(order);
    }

    public OrderDetails get(int id) {
        return orderDetailsRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        orderDetailsRepository.deleteById(id);
    }
}
