package com.tnsif.shoppingmall.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private LocalDate manufacturing;
    private LocalDate expiry;
    private float price;
    private String category;

    // Many items -> One mall
    @ManyToOne
    @JoinColumn(name = "mall_id")
    private Mall mall;

    public Item() {}

    public Item(long id, String name, LocalDate manufacturing, LocalDate expiry, float price, String category, Mall mall) {
        this.id = id;
        this.name = name;
        this.manufacturing = manufacturing;
        this.expiry = expiry;
        this.price = price;
        this.category = category;
        this.mall = mall;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getManufacturing() { return manufacturing; }
    public void setManufacturing(LocalDate manufacturing) { this.manufacturing = manufacturing; }

    public LocalDate getExpiry() { return expiry; }
    public void setExpiry(LocalDate expiry) { this.expiry = expiry; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Mall getMall() { return mall; }
    public void setMall(Mall mall) { this.mall = mall; }
}
