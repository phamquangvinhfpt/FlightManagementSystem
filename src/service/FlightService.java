/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

import model.Flight;
import repository.FlightRepository;

/**
 *
 * @author Admin
 */
public class FlightService {
    private FlightRepository flightRepository;
    public FlightService(){
        flightRepository = new FlightRepository();
    }
    public void addFlight(Flight flight){
        flightRepository.addFlight(flight);
    }

    public List<Flight> getAllFlight(){
        return flightRepository.getAllFlights();
    }
}
