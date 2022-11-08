package com.example.coursework2;

import java.time.LocalDate;
import java.time.LocalTime;

public class MonthlyEvent extends Event{

    public MonthlyEvent(String heading, String description, LocalDate date, LocalTime time, TypeEvent typeEvent) {
        super(heading, description, date, time, typeEvent);
    }

    @Override
    public String toString() {
        return super.toString() + ", повторять ежемесячно";
    }

    @Override
    public boolean isAvailable(LocalDate inputLocalDate) {
        LocalDate startDate = getDate();
        while (!startDate.isAfter(inputLocalDate)){
            if(startDate.equals(inputLocalDate)){
                return true;
            }
            startDate = startDate.plusMonths(1);
        }
        return false;
    }
}
