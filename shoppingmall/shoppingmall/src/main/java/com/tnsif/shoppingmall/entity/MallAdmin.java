package com.tnsif.shoppingmall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
 import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mall_admin")
public class MallAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String password;
    private String phone;

    @OneToOne(mappedBy = "mallAdmin")
    @JsonIgnore
    private Mall mall;

    public MallAdmin() {}

    public MallAdmin(int id, String name, String password, String phone, Mall mall) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.mall = mall;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Mall getMall() { return mall; }
    public void setMall(Mall mall) { this.mall = mall; }
}
