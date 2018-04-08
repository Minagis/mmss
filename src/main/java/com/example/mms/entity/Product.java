package com.example.mms.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Product extends AbstractEntity {

    private String title;
    private BigDecimal price;
    private Integer weight;
    private String brand;
    private String color;
    private String description;
    private Integer amount;

    @ManyToMany
    @JoinTable(name = "purchase_product",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "purchase_id", referencedColumnName = "id"))
    private Set<Product> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (weight != null ? !weight.equals(product.weight) : product.weight != null) return false;
        if (brand != null ? !brand.equals(product.brand) : product.brand != null) return false;
        if (color != null ? !color.equals(product.color) : product.color != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        return amount != null ? amount.equals(product.amount) : product.amount == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }
}
