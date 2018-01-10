package com.example.mms.entity;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table (name = "order")
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer deliveryMethod;
    private Integer paymentStatus;
    private Integer paymentMethod;
    private Integer orderStatus;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ordersproduct",
            joinColumns = @JoinColumn(name = "orderid", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "productid", referencedColumnName = "id"))
    private Set<Product> products;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clientid")
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "adressid")
    private Address address;

    public Order() {
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

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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
