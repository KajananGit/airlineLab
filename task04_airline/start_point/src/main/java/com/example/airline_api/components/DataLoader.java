package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Passenger passenger1 = new Passenger("Kajanan", "svdsfv@gmail.com");
        Passenger passenger2 = new Passenger("Tom", "tomsdsfe@Hotmail.com");
        Passenger passenger3 = new Passenger("Peter", "peter123@gmail.com");

        Flight flight1 = new Flight("Japan", 30, "12/06/2024", "3am");
        Flight flight2 = new Flight("USA", 38, "25/10/2024", "2pm");
        Flight flight3 = new Flight("Italy", 8, "05/04/2024", "10am");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        passengerRepository.save(passenger1);
        passengerRepository.save(passenger2);
        passengerRepository.save(passenger3);



    }
}
