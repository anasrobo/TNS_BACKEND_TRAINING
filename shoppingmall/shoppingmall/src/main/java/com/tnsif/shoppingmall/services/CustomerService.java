package com.tnsif.shoppingmall.services;

import org.springframework.stereotype.Service;

import com.tnsif.shoppingmall.entity.Customer;
import com.tnsif.shoppingmall.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer get(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        customerRepository.deleteById(id);
    }
}
