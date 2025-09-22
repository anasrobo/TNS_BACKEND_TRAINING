package com.tnsif.shoppingmall.entity;

import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shopId;

    private String shopCategory;
    private String shopName;
    private String customers;
    private String shopStatus;
    private String leaseStatus;

    // One shop ⇄ One owner (bidirectional)
    @OneToOne(mappedBy = "shop")
    private ShopOwner shopOwner;

    // Many shops → One mall
    @ManyToOne
    @JoinColumn(name = "mall_id")
    private Mall mall;

    // One shop → Many employees
    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> shopEmployeeID;

    // Default constructor
    public Shop() {}

    public Shop(int shopId, String shopCategory, String shopName, String customers,
                String shopStatus, ShopOwner shopOwner, String leaseStatus,
                Set<Employee> shopEmployeeID, Mall mall) {
        this.shopId = shopId;
        this.shopCategory = shopCategory;
        this.shopName = shopName;
        this.customers = customers;
        this.shopStatus = shopStatus;
        this.shopOwner = shopOwner;
        this.leaseStatus = leaseStatus;
        this.shopEmployeeID = shopEmployeeID;
        this.mall = mall;
    }

    // Getters & setters
    public int getShopId() { return shopId; }
    public void setShopId(int shopId) { this.shopId = shopId; }

    public String getShopCategory() { return shopCategory; }
    public void setShopCategory(String shopCategory) { this.shopCategory = shopCategory; }

    public String getShopName() { return shopName; }
    public void setShopName(String shopName) { this.shopName = shopName; }

    public String getCustomers() { return customers; }
    public void setCustomers(String customers) { this.customers = customers; }

    public String getShopStatus() { return shopStatus; }
    public void setShopStatus(String shopStatus) { this.shopStatus = shopStatus; }

    public String getLeaseStatus() { return leaseStatus; }
    public void setLeaseStatus(String leaseStatus) { this.leaseStatus = leaseStatus; }

    public ShopOwner getShopOwner() { return shopOwner; }
    public void setShopOwner(ShopOwner shopOwner) { this.shopOwner = shopOwner; }

    public Set<Employee> getShopEmployeeID() { return shopEmployeeID; }
    public void setShopEmployeeID(Set<Employee> shopEmployeeID) { this.shopEmployeeID = shopEmployeeID; }

    public Mall getMall() { return mall; }
    public void setMall(Mall mall) { this.mall = mall; }
}