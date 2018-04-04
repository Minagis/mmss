package com.example.mms.entity;

import java.util.Set;
import javax.persistence.*;

@Entity
public class Purchase extends AbstractEntity {

    private Integer deliveryMethod;
    private Integer paymentStatus;
    private Integer paymentMethod;
    private Integer purchaseStatus;

    @ManyToMany
    @JoinTable(name = "purchase_product",
            joinColumns = @JoinColumn(name = "purchase_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    private Set<Product> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;

        Purchase purchase = (Purchase) o;

        if (getDeliveryMethod() != null ? !getDeliveryMethod().equals(purchase.getDeliveryMethod()) : purchase.getDeliveryMethod() != null)
            return false;
        if (getPaymentStatus() != null ? !getPaymentStatus().equals(purchase.getPaymentStatus()) : purchase.getPaymentStatus() != null)
            return false;
        if (getPaymentMethod() != null ? !getPaymentMethod().equals(purchase.getPaymentMethod()) : purchase.getPaymentMethod() != null)
            return false;
        if (getPurchaseStatus() != null ? !getPurchaseStatus().equals(purchase.getPurchaseStatus()) : purchase.getPurchaseStatus() != null)
            return false;
        if (getProducts() != null ? !getProducts().equals(purchase.getProducts()) : purchase.getProducts() != null)
            return false;
        if (getClient() != null ? !getClient().equals(purchase.getClient()) : purchase.getClient() != null)
            return false;
        return getAddress() != null ? getAddress().equals(purchase.getAddress()) : purchase.getAddress() == null;
    }

    @Override
    public int hashCode() {
        int result = getDeliveryMethod() != null ? getDeliveryMethod().hashCode() : 0;
        result = 31 * result + (getPaymentStatus() != null ? getPaymentStatus().hashCode() : 0);
        result = 31 * result + (getPaymentMethod() != null ? getPaymentMethod().hashCode() : 0);
        result = 31 * result + (getPurchaseStatus() != null ? getPurchaseStatus().hashCode() : 0);
        result = 31 * result + (getProducts() != null ? getProducts().hashCode() : 0);
        result = 31 * result + (getClient() != null ? getClient().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        return result;
    }

    public Integer getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(Integer deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(Integer purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
