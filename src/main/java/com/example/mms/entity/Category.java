package com.example.mms.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @SequenceGenerator(name = "category_generator", sequenceName = "category_sequence", allocationSize = 1)
    @GeneratedValue(generator = "category_generator")
    private Integer id;
    private String type;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

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
