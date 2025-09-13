package com.example.spring_boot;

import com.example.client.Patient;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }
    @PostMapping("/api/receiveObject")
    public String receiveObject(@RequestBody byte[] serializedPatient) {

        try
        {
            System.out.println(serializedPatient.length);
            ByteArrayInputStream bis = new ByteArrayInputStream(serializedPatient);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Patient deserializedPatient = (Patient) ois.readObject();
            ois.close();
            System.out.println("Received patient: " + deserializedPatient.toString());
            return "Patient created: " + deserializedPatient.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deserializing patient: " + e.getMessage();
        }


    }
}
