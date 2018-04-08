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

    public Purchase() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;

        if (deliveryMethod != null ? !deliveryMethod.equals(purchase.deliveryMethod) : purchase.deliveryMethod != null)
            return false;
        if (paymentStatus != null ? !paymentStatus.equals(purchase.paymentStatus) : purchase.paymentStatus != null)
            return false;
        if (paymentMethod != null ? !paymentMethod.equals(purchase.paymentMethod) : purchase.paymentMethod != null)
            return false;
        return purchaseStatus != null ? purchaseStatus.equals(purchase.purchaseStatus) : purchase.purchaseStatus == null;
    }

    @Override
    public int hashCode() {
        int result = deliveryMethod != null ? deliveryMethod.hashCode() : 0;
        result = 31 * result + (paymentStatus != null ? paymentStatus.hashCode() : 0);
        result = 31 * result + (paymentMethod != null ? paymentMethod.hashCode() : 0);
        result = 31 * result + (purchaseStatus != null ? purchaseStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "deliveryMethod=" + deliveryMethod +
                ", paymentStatus=" + paymentStatus +
                ", paymentMethod=" + paymentMethod +
                ", purchaseStatus=" + purchaseStatus +
                '}';
    }
}
