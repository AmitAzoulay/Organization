package com.example.spring_boot;

import java.util.Date;

public class Staff extends Patient
{
    private Date joined;
    private String[] education;
    private String[] certification;
    private String[] languages;

    public Staff(String title, String givenName, String familyName, String middleName, Date birth,
                 Date accepted, Address homeAddress, History sickness, String[] prescriptions,
                 String[] allergies, String[] specialReqs, Gender gender,
                 Date joined, String[] education, String[] certification, String[] languages, Phone phone) {

        super(title, givenName, familyName, middleName, birth, accepted, homeAddress,
                sickness, prescriptions, allergies, specialReqs, gender, phone);

        this.joined = joined;
        this.education = education;
        this.certification = certification;
        this.languages = languages;
    }
    public Date getJoined()
    {
        return joined;
    }
    public String getEducation()
    {
        String finalEdc = "";
        for (String s : education)
        {
            finalEdc += s;
        }
        return finalEdc;
    }
    public String getCertification()
    {
        String finalCer = "";
        for (String s : certification)
        {
            finalCer += s;
        }
        return finalCer;
    }
    public String getLanguages()
    {
        String finalLang = "";
        for (String s : languages)
        {
            finalLang += s;
        }
        return finalLang;
    }
}
