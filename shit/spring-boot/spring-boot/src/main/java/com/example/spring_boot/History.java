package com.example.spring_boot;
import java.io.Serializable;
import java.util.Date;
public class History implements Serializable{
    String conditions;
    Date startDate;
    Date endDate;
    String notes;

    public History(String condition, Date startDate, Date endDate, String notes) {
        this.conditions = condition;
        this.startDate = startDate;
        this.endDate = endDate;
        this.notes = notes;
    }

    public String getConditions()
    {
        return conditions;
    }
    public Date getStartDate()
    {
        return startDate;
    }
    public Date getEndDate()
    {
        return endDate;
    }
    public String getNotes()
    {
        return notes;
    }
    @Override
    public String toString() {
        return "Condition: " + conditions + ", Start Date: " + startDate + ", End Date: " + endDate + ", Notes: " + notes;
    }
}
