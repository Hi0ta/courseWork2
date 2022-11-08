package com.example.coursework2;

public enum TypeEvent {

    PERSONAL("личное"),
    WORKER("рабочее");

    private String name;
    TypeEvent(String name) {
        this.name = name;
    }

    public String getName() {return name;}

}
