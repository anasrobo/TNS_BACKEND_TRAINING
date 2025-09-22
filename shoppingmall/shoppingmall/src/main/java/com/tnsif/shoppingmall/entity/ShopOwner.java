package com.tnsif.shoppingmall.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shop_owner")
public class ShopOwner {

    @Id
    private int id;

    private String name;
    private String address;
    private LocalDate dob;

    // One owner → One shop
    @OneToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "shopId")
    @JsonIgnore
    private Shop shop;

    // Default constructor
    public ShopOwner() {}

    // Param constructor
    public ShopOwner(int id, String name, String address, LocalDate dob, Shop shop) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.dob = dob;
        this.shop = shop;
    }

    // 🔹 Getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public Shop getShop() { return shop; }
    public void setShop(Shop shop) { this.shop = shop; }
}