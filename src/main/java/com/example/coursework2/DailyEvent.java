package com.example.coursework2;

import java.time.LocalDate;
import java.time.LocalTime;

public class DailyEvent extends Event{

    public DailyEvent(String heading, String description, LocalDate date, LocalTime time, TypeEvent typeEvent) {
        super(heading, description, date, time, typeEvent);
    }

    @Override
    public String toString() {
        return super.toString() + ", повторять ежедневно";
    }

    @Override
    public boolean isAvailable(LocalDate inputLocalDate) {
        LocalDate startDate = getDate();
        while (!startDate.isAfter(inputLocalDate)){
            if(startDate.equals(inputLocalDate)){
                return true;
            }
            startDate = startDate.plusDays(1);
        }
        return false;
    }
}
