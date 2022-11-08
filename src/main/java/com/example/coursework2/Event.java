package com.example.coursework2;

import jdk.jfr.EventType;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Event implements Repeatable{
    private int id;
    private static int counter = 1;
    private String heading;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private TypeEvent typeEvent;


    public Event(String heading, String description, LocalDate date, LocalTime time, TypeEvent typeEvent) {
        this.id = counter++;
        this.setHeading(heading);
        this.setDescription(description);
        this.setDate(date);
        this.setTime(time);
        this.typeEvent = typeEvent;
    }

    public int getId() {return id;}

    public String getHeading() {return heading;}

    public String getDescription() {return description;}
    public LocalDate getDate() {return date;}

    public LocalTime getTime() {return time;}

    public TypeEvent getTypeEvent() {return typeEvent;}

    public void setHeading(String heading) {
        if (heading == null || heading.isBlank()){
            throw new IllegalArgumentException("Заголовок обязательно должен быть заполнен");
        }else {
            this.heading = heading;
        }
    }

    public void setDescription(String description) {
        if (description == null || description.isBlank()){
            throw new IllegalArgumentException("Описание обязательно должно быть заполнено");
        }else {
            this.description = description;
        }
    }

    public void setDate(LocalDate date) {
        if (date == null) {
            this.date = LocalDate.now();
        } else {
            this.date = date;
        }
    }
    public void setTime(LocalTime time) {
        if (time == null) {
            this.time = LocalTime.of(12, 00);
        } else {
            this.time = time;
        }
    }

    @Override
    public int hashCode() {return Objects.hash(heading, description, date);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return heading.equals(event.heading) && description.equals(event.description) && date.equals(event.date);
    }

    @Override
    public boolean isAvailable(LocalDate inputLocalDate) {
       return inputLocalDate.isEqual(getDate());
    }

    @Override
    public String toString() {
        return /*"Событие: " + " № " + id + */" что произойдет: " + heading + ", подробности: " + description/* +
                ", когда: " + date*/ + ", во сколько: " + time + ", тип: " + typeEvent.getName();
    }
}
