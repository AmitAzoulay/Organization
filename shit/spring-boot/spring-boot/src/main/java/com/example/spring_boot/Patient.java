package com.example.spring_boot;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.sql.*;
import java.util.*;
import java.io.ObjectInputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;


public class Patient extends Person implements Serializable
{

    String id;
    int age;
    Date accepted;
    History sickness;
    String[] prescriptions;
    String[] allergies;
    String[] specialRwqs;


    public Patient(String title, String givenName, String familyName, String middleName, Date birth, 
    Date accepted, Address homeAddress, History sickness, String[] prescriptions, String[] allergies,
    String[] specialRwqs, Gender gender, Phone phone)
    {
        super(title, givenName, familyName, middleName, birth, gender, homeAddress, phone);
        this.id = UUID.randomUUID().toString();
        this.age = (new Date().getYear() - birth.getYear());
        this.accepted = accepted;
        this.sickness = sickness;
        this.prescriptions = prescriptions;
        this.allergies = allergies;
        this.specialRwqs = specialRwqs;
    }
    public Patient() {
        super("", "", "", null, new Date(),  new Gender("gggg"), new Address("123 Main St", "Springfield", "IL", "62701", "USA"), new Phone("ISR", "972", "9898989"));  // Call to the superclass constructor with default values
        this.id = UUID.randomUUID().toString();
        this.age = 0;
        this.accepted = new Date();
        this.sickness = null;
        this.prescriptions = new String[0]; 
        this.allergies = new String[0];
        this.specialRwqs = new String[0];
    }

    public String getPrescriptions()
    {
        String prescriptions = "";
        for  (String prescription : this.prescriptions)
        {
            prescriptions += prescription;
        }
        return prescriptions;
    }
    public String getAllergies()
    {
        String allergies = "";
        for (String allergy : this.allergies)
        {
            allergies += allergy;
        }
        return allergies;
    }
    public String getSpecialRwqs()
    {
        String specialRwqs = "";
        for (String specialRwq : this.specialRwqs)
        {
            specialRwqs += specialRwq;
        }
        return specialRwqs;
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
    {

        in.defaultReadObject();
        var url = "jdbc:sqlite:my.db";

        String createTableQuery = """
                CREATE TABLE IF NOT EXISTS patients (
                     id VARCHAR(255) PRIMARY KEY,
                    age INT,
                    accepted DATE,
                    conditions TEXT,
                    startDate DATE,
                    endDate DATE,
                    notes TEXT,
                    prescriptions TEXT,
                    allergies TEXT,
                    specialRwqs TEXT
                );
                """;
        try (var conn = DriverManager.getConnection(url);
             var stmt = conn.createStatement())
        {
            stmt.execute(createTableQuery);

            String insertPatientQuery = """
                INSERT or IGNORE INTO patients (id, age, accepted, conditions, startDate, endDate, notes, prescriptions, allergies, specialRwqs) 
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
                """;

            try(var pstmt = conn.prepareStatement(insertPatientQuery);)
            {
                pstmt.setString(1, id);
                pstmt.setInt(2, age);
                pstmt.setDate(3, new java.sql.Date(accepted.getTime()));
                pstmt.setString(4, this.sickness.getConditions());
                pstmt.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(this.sickness.getStartDate()));
                pstmt.setString(6, new SimpleDateFormat("yyyy-MM-dd").format(this.sickness.getEndDate()));
                pstmt.setString(7, this.sickness.getNotes());
                pstmt.setString(8, this.getPrescriptions());
                pstmt.setString(9, this.getAllergies());
                pstmt.setString(10, this.getSpecialRwqs());
                int rows = pstmt.executeUpdate();
                if (rows > 0)
                {
                    System.out.println("Insertion successful.");
                }
                else
                {
                    System.out.println("Insertion ignored");
                }
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }

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
   


