package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.FlightDTO;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;


    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
         return flightRepository.findAll();
    }

    public Flight getFlightById(long id) {
        return flightRepository.findById(id).get();
    }

    public Flight addNewFlight(FlightDTO flightDTO) {
        Flight flight = new Flight(flightDTO.getDestination(), flightDTO.getCapacity(), flightDTO.getDepartureDate(), flightDTO.getDepartureTime());
        flightRepository.save(flight);
        return flight;
    }

    public Flight addPassengerToFlight(long id, FlightDTO flightDTO) {
        Flight flight = flightRepository.findById(id).get();
        for(Long passengerIds : flightDTO.getPassengerIds()) {
            Passenger passenger = passengerRepository.findById(passengerIds).get();
            flight.addPassenger(passenger);
        }
        flightRepository.save(flight);
        return flight;
    }

    public void deleteFlight(long id) {
        flightRepository.deleteById(id);
    }

    public List<Flight> getFlightByDestination(String destination){
        return flightRepository.findByDestination(destination);
    }
}
