package com.example.demo;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class Patient extends Person implements Serializable
{
    String id;
    int age;
    Date accepted;
    History sickness;
    String[] prescriptions;
    String[] allergies;
    String[] specialRwqs;
    private static final long serialVersionUID = 1L;

    public Patient(String title, String givenName, String familyName, String middleName, Date birth, 
    Date accepted, Address homeAddress, History sickness, String[] prescriptions, String[] allergies,
    String[] specialRwqs, Gender gender)
    {
        super(title, givenName, familyName, middleName, birth, gender, homeAddress);
        this.id = UUID.randomUUID().toString(); 
        this.age = (new Date().getYear() - birth.getYear());
        this.accepted = accepted;
        this.sickness = sickness;
        this.prescriptions = prescriptions;
        this.allergies = allergies;
        this.specialRwqs = specialRwqs;
    }
    public Patient() {
        super("", "", "", null, new Date(),  new Gender("gggg"), new Address("123 Main St", "Springfield", "IL", "62701", "USA"));  // Call to the superclass constructor with default values
        this.id = UUID.randomUUID().toString();
        this.age = 0;
        this.accepted = new Date();
        this.sickness = null;
        this.prescriptions = new String[0]; 
        this.allergies = new String[0];
        this.specialRwqs = new String[0];
    }
    @Override
    public String toString() {
        return "Patient{" +
               "id='" + id + '\'' +
               ", age=" + age +
               ", accepted=" + accepted +
               ", sickness=" + (sickness == null ? "null" : sickness.toString()) +
               ", prescriptions=" + Arrays.toString(prescriptions) +
               ", allergies=" + Arrays.toString(allergies) +
               ", specialRwqs=" + Arrays.toString(specialRwqs) +
               ", person=" + super.toString() +
               '}';
    }
}
   


