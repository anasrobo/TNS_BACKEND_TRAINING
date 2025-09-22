package com.tnsif.shoppingmall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String type; // e.g., CUSTOMER, OWNER, ADMIN
    private String password;

    public AppUser() {}

    public AppUser(int id, String name, String type, String password) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.password = password;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
