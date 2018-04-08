package com.example.mms.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category extends AbstractEntity {

    private String type;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    public Category() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return type != null ? type.equals(category.type) : category.type == null;
    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Category{" +
                "type='" + type + '\'' +
                '}';
    }
}
