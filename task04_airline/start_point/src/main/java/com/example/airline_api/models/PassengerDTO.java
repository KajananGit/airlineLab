package com.example.airline_api.models;

import java.util.ArrayList;
import java.util.List;

public class PassengerDTO {
    private String name;
    private String email;
    private List<Long> flightIds;

    public PassengerDTO(String name, String email) {
        this.name = name;
        this.email = email;
        this.flightIds = new ArrayList<>();
    }

    public PassengerDTO(){}

//    GETTERS and SETTERS


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Long> getFlightIds() {
        return flightIds;
    }

    public void setFlightIds(List<Long> flightIds) {
        this.flightIds = flightIds;
    }
}
