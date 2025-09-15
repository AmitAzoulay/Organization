package com.example.spring_boot;

import java.io.Serializable;

public class Phone implements Serializable {

    private String countryCode;
    private String areaCode;
    private String number;

    public Phone(String countryCode, String areaCode, String number) {
        this.countryCode = countryCode;
        this.areaCode = areaCode;
        this.number = number;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public String getAreaCode()
    {
        return areaCode;
    }

    public String getNumber()
    {
        return number;
    }

    @Override
    public String toString() {
        return countryCode + ", " + areaCode + ", " + number;
    }
}