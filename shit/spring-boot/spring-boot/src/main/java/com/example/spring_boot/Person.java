package com.example.spring_boot;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
   
    private String title;
    private String givenName;
    private String familyName;
    private String middleName;
    FullName name;
    Gender gender;
    Date birthDate;
    private Address homeAddress;
    private Phone phone;

    public Person(String title, String givenName, String familyName, String middleName, Date birthDate, Gender gender, Address homeAddress, Phone phone)
    {
        this.title = title;
        this.givenName = givenName;
        this.middleName = middleName;
        this.familyName = familyName;
        this.name = new FullName(givenName, middleName, familyName);
        this.birthDate = birthDate;
        this.gender = gender;
        this.homeAddress = new Address(homeAddress.street, homeAddress.city, homeAddress.state, homeAddress.postalCode, homeAddress.country);
        this.phone = new Phone(phone.getCountryCode(), phone.getAreaCode(), phone.getNumber());
    }

    public String getTitle()
    {
        return title;
    }
    public String  getGivenName()
    {
        return givenName;
    }
    public String  getFamilyName()
    {
        return familyName;
    }
    public String  getMiddleName()
    {
        return middleName;
    }
    public FullName getName()
    {
        return name;
    }
    public Gender getGender()
    {
        return gender;
    }
    public Date getBirthDate()
    {
        return birthDate;
    }
    public Address getHomeAddress()
    {
        return homeAddress;
    }

    @Override
    public String toString() {
        return "Person{" +
               "title='" + title + '\'' +
               ", givenName='" + givenName + '\'' +
               ", middleName='" + middleName + '\'' +
               ", familyName='" + familyName + '\'' +
               ", name=" + (name == null ? "null" : name.toString()) +
               ", gender=" + (gender == null ? "null" : gender.toString()) +
               ", birthDate=" + birthDate +
               ", homeAddress=" + (homeAddress == null ? "null" : homeAddress.toString()) +
                ", phone=" + (phone == null ? "null" : phone.toString()) +
               '}';
    }
}