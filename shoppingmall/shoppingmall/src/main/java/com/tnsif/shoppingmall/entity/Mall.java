package com.tnsif.shoppingmall.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mall")
public class Mall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String mallName;
    private String location;
    private String categories;

    // One mall -> One admin (owning side)
    @OneToOne
    @JoinColumn(name = "mall_admin_id")
    private MallAdmin mallAdmin;

    // One mall -> Many shops
    @OneToMany(mappedBy = "mall")
    @JsonIgnore
    private Set<Shop> shops;

    public Mall() {}

    public Mall(long id, MallAdmin mallAdmin, String mallName, String location, String categories, Set<Shop> shops) {
        this.id = id;
        this.mallAdmin = mallAdmin;
        this.mallName = mallName;
        this.location = location;
        this.categories = categories;
        this.shops = shops;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getMallName() { return mallName; }
    public void setMallName(String mallName) { this.mallName = mallName; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getCategories() { return categories; }
    public void setCategories(String categories) { this.categories = categories; }

    public MallAdmin getMallAdmin() { return mallAdmin; }
    public void setMallAdmin(MallAdmin mallAdmin) { this.mallAdmin = mallAdmin; }

    public Set<Shop> getShops() { return shops; }
    public void setShops(Set<Shop> shops) { this.shops = shops; }
}
