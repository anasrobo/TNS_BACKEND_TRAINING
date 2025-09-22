package com.tnsif.shoppingmall.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDateTime dateOfPurchase;
    private float total;
    private String paymentMode;

    // Many orders -> One customer
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Many orders -> One shop
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public OrderDetails() {}

    public OrderDetails(int id, LocalDateTime dateOfPurchase, float total, String paymentMode, Customer customer, Shop shop) {
        this.id = id;
        this.dateOfPurchase = dateOfPurchase;
        this.total = total;
        this.paymentMode = paymentMode;
        this.customer = customer;
        this.shop = shop;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDateTime getDateOfPurchase() { return dateOfPurchase; }
    public void setDateOfPurchase(LocalDateTime dateOfPurchase) { this.dateOfPurchase = dateOfPurchase; }

    public float getTotal() { return total; }
    public void setTotal(float total) { this.total = total; }

    public String getPaymentMode() { return paymentMode; }
    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Shop getShop() { return shop; }
    public void setShop(Shop shop) { this.shop = shop; }
}
