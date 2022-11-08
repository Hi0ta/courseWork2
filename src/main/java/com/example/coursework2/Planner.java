package com.example.coursework2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Planner {
    private Map<Integer, Event> planner = new HashMap<>();

    //public Map<Integer, Event> getPlanner() {return planner;}

    @Override
    public String toString() {return "; " + planner.values();}

    public void addEvent(Event event) {planner.put(event.getId(), event);}

    public void deleteEvent(Integer key){planner.remove(key);}

    public void printPlannerForTheDate(LocalDate inputLocalDate) {
        for (Map.Entry<Integer, Event> IntegerEventEntry: planner.entrySet()){
            Event event = IntegerEventEntry.getValue();
            if (event.isAvailable(inputLocalDate)){
                System.out.println(event);
            }
        }

    }



}
