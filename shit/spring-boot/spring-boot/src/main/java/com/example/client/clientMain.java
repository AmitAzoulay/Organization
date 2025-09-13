package com.example.client;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

public class clientMain {
    public static Patient buildPatient()
    {
        Address address = new Address("123 Main St", "Springfield", "IL", "62701", "USA");
        Gender gender = new Gender("male");
        Date birthDate = new Date(90, 0, 1); // January 1, 1990
        Date acceptedDate = new Date(122, 0, 1); // January 1, 2022
        History history = new History("Flu", new Date(122, 0, 1), new Date(122, 0, 10), "Recovered well");
        String[] prescriptions = {"Medicine A", "Medicine B"};
        String[] allergies = {"Peanuts"};
        String[] specialRwqs = {"Wheelchair access"};

        Patient patient = new Patient("Mr.", "John", "Doe", "M", birthDate, acceptedDate, address, history, prescriptions, allergies, specialRwqs,gender);
        return patient;
    }
    public static void main(String[] args)
    {
        Patient patient = buildPatient();

        try
        {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(patient);
            oos.flush();
            byte[] serializedData = bos.toByteArray();
            oos.close();

            HttpClient client = HttpClient.newHttpClient();

            System.out.println(serializedData.length);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/receiveObject"))
                    .header("Content-Type", "application/x-java-serialized-object")
                    .POST(HttpRequest.BodyPublishers.ofByteArray(serializedData))
                    .build();


            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Response Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

            // Deserialize the Patient object from the byte array
            ByteArrayInputStream bis = new ByteArrayInputStream(serializedData);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Patient deserializedPatient = (Patient) ois.readObject();
            ois.close();

            System.out.println("Deserialized Patient: " + deserializedPatient.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
