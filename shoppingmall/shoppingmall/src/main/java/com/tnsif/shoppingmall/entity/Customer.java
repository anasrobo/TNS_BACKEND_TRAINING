package com.tnsif.shoppingmall.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String phone;
    private String email;

    // One customer -> Many orders (practical simplification)
    @OneToMany(mappedBy = "customer")
    private Set<OrderDetails> orders;

    public Customer() {}

    public Customer(int id, String name, String phone, String email, Set<OrderDetails> orders) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.orders = orders;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Set<OrderDetails> getOrders() { return orders; }
    public void setOrders(Set<OrderDetails> orders) { this.orders = orders; }
}
