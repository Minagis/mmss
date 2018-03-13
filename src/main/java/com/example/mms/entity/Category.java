package com.example.mms.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category extends AbstractEntity {

    private String type;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

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
