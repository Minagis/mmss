package com.example.mms.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category extends AbstractEntity {

    private String type;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;

        Category category = (Category) o;

        if (getType() != null ? !getType().equals(category.getType()) : category.getType() != null) return false;
        return getProducts() != null ? getProducts().equals(category.getProducts()) : category.getProducts() == null;
    }

    @Override
    public int hashCode() {
        int result = getType() != null ? getType().hashCode() : 0;
        result = 31 * result + (getProducts() != null ? getProducts().hashCode() : 0);
        return result;
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
