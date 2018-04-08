package com.example.mms.entity;

import javax.persistence.*;

@Entity
public class Address extends AbstractEntity {

    private String country;
    private String city;
    private Integer postcode;
    private String street;
    private Integer flat;
    private Integer house;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public Address() {
    }

    public Address(String country, String city, Integer postcode, String street, Integer flat, Integer house, Client client) {
        this.country = country;
        this.city = city;
        this.postcode = postcode;
        this.street = street;
        this.flat = flat;
        this.house = house;
        this.client = client;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (postcode != null ? !postcode.equals(address.postcode) : address.postcode != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;
        if (flat != null ? !flat.equals(address.flat) : address.flat != null) return false;
        return house != null ? house.equals(address.house) : address.house == null;
    }

    @Override
    public int hashCode() {
        int result = country != null ? country.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (flat != null ? flat.hashCode() : 0);
        result = 31 * result + (house != null ? house.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postcode=" + postcode +
                ", street='" + street + '\'' +
                ", flat=" + flat +
                ", house=" + house +
                '}';
    }
}
