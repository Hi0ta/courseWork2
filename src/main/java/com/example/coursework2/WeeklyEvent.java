package com.example.coursework2;

import java.time.LocalDate;
import java.time.LocalTime;

public class WeeklyEvent extends Event{

    public WeeklyEvent(String heading, String description, LocalDate date, LocalTime time, TypeEvent typeEvent) {
        super(heading, description, date, time, typeEvent);
    }

    @Override
    public String toString() {
        return super.toString() + ", повторять еженедельно";
    }

    @Override
    public boolean isAvailable(LocalDate inputLocalDate) {
        LocalDate startDate = getDate();
        while (!startDate.isAfter(inputLocalDate)){
            if(startDate.equals(inputLocalDate)){
                return true;
            }
            startDate = startDate.plusWeeks(1);
        }
        return false;
    }
}
