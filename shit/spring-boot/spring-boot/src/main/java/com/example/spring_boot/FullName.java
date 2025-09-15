package com.example.spring_boot;
import java.io.Serializable;

public class FullName implements Serializable {
    String givenName;
    String familyName;
    String middleName;

    public FullName(String givenName, String middleName, String familyName) {
        this.givenName = givenName;
        this.middleName = middleName;
        this.familyName = familyName;
    }
    public String getGivenName()
    {
        return givenName;
    }
    public String getFamilyName()
    {
        return familyName;
    }
    public String getMiddleName()
    {
        return middleName;
    }
    @Override
    public String toString() {
        return givenName + " " + (middleName != null ? middleName + " " : "") + familyName;
    }
}
