package com.example.spring_boot;

import java.util.Date;

public class Doctor extends  OperationsStaff
{
    private String[] speciality;
    private String[] locations;

    public Doctor(String title, String givenName, String familyName, String middleName, Date birth,
                  Date accepted, Address homeAddress, History sickness, String[] prescriptions,
                  String[] allergies, String[] specialReqs, Gender gender,
                  Date joined, String[] education, String[] certification, String[] languages,  String[] speciality, String[] locations, Phone phone)
    {
        super(title, givenName, familyName, middleName, birth, accepted, homeAddress, sickness, prescriptions, allergies,
                specialReqs, gender, joined, education, certification, languages, phone);
        this.speciality = speciality;
        this.locations = locations;

    }
}
