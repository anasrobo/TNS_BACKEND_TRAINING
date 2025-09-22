package com.tnsif.shoppingmall.controller;

import com.tnsif.shoppingmall.entity.Employee;
import com.tnsif.shoppingmall.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable int id) {
        Employee e = employeeService.get(id);
        return e != null ? ResponseEntity.ok(e) : ResponseEntity.notFound().build();
    }
}
