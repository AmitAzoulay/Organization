package com.example.spring_boot;

import java.util.Date;

public class AdministrativeStaff extends Staff{
    public AdministrativeStaff(String title, String givenName, String familyName, String middleName, Date birth,
                           Date accepted, Address homeAddress, History sickness, String[] prescriptions,
                           String[] allergies, String[] specialReqs, Gender gender,
                           Date joined, String[] education, String[] certification, String[] languages, Phone phone)
    {
        super(title, givenName, familyName, middleName, birth, accepted, homeAddress, sickness, prescriptions, allergies,
                specialReqs, gender, joined, education, certification, languages, phone);
    }
}
