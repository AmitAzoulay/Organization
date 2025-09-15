package com.example.spring_boot;

public class Hospital
{
    Address address;
    String name;
    Phone phone;

    public  Hospital(Address address, String name, Phone phone)
    {
        this.address = address;
        this.name = name;
        this.phone = phone;
    }
}
