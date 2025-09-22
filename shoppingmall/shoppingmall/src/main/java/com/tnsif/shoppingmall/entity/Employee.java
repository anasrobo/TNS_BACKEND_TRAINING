package com.tnsif.shoppingmall.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    private int id;

    private String name;
    private LocalDate dob;
    private float salary;
    private String address;
    private String designation;

    // Many employees → One shop
    @ManyToOne
    @JoinColumn(name = "shop_id")
    @JsonIgnore
    private Shop shop;

    // Default constructor
    public Employee() {}

    // Param constructor
    public Employee(int id, String name, LocalDate dob, float salary,
                    String address, String designation, Shop shop) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
        this.address = address;
        this.designation = designation;
        this.shop = shop;
    }

    // 🔹 Getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public float getSalary() { return salary; }
    public void setSalary(float salary) { this.salary = salary; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public Shop getShop() { return shop; }
    public void setShop(Shop shop) { this.shop = shop; }
}