package com.example.spring_boot;

import java.io.Serializable;

public class Address implements Serializable{
    String street;
    String city;
    String state;
    String postalCode;
    String country;

    public Address(String street, String city, String state, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }
    public String getStreet()
    {
        return street;
    }
    public String getCity()
    {
        return city;
    }
    public String getState()
    {
        return state;
    }
    public String getPostalCode()
    {
        return postalCode;
    }
    public String getCountry()
    {
        return country;
    }
    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + postalCode + ", " + country;
    }
}
