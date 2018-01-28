package com.example.mms.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private String type;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
