package com.example.demo;
import java.io.Serializable;
import java.util.Date;
public class History implements Serializable{
    private static final long serialVersionUID = 1L;
    String condition;
    Date startDate;
    Date endDate;
    String notes;

    public History(String condition, Date startDate, Date endDate, String notes) {
        this.condition = condition;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Condition: " + condition + ", Start Date: " + startDate + ", End Date: " + endDate + ", Notes: " + notes;
    }
}
