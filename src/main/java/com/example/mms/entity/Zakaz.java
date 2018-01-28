package com.example.mms.entity;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table (name = "zakaz")
public class Zakaz {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    private Integer deliveryMethod;
    private Integer paymentStatus;
    private Integer paymentMethod;
    private Integer zakazStatus;

    @ManyToMany
    @JoinTable(name = "zakazproduct",
            joinColumns = @JoinColumn(name = "zakazid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "productid", referencedColumnName = "id"))
    private Set<Product> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clientid")
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressid")
    private Address address;

    public Zakaz() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getZakazStatus() {
        return zakazStatus;
    }

    public void setZakazStatus(Integer zakazStatus) {
        this.zakazStatus = zakazStatus;
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
