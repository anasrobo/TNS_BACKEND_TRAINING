package com.tnsif.shoppingmall.services;

import org.springframework.stereotype.Service;

import com.tnsif.shoppingmall.entity.Employee;
import com.tnsif.shoppingmall.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee get(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
