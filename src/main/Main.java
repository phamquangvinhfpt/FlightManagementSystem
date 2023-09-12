/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;

import model.Flight;
import model.Menu;
import service.FlightService;
import service.Utils;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        boolean check = true;
        boolean cont = false;
        int choice = 0;
        Menu menu = new Menu();
//        File file = new File();
        menu.addItem("1. Flight schedule management");
        menu.addItem("2. Passenger reservation and booking");
        menu.addItem("3. Passenger check-in and seat allocation");
        menu.addItem("4. Crew management and assignments");
        menu.addItem("5. Administrator access for system management");
        menu.addItem("6. Data storage for flight details, reservations, and assignments");
        menu.addItem("7. Exit");
        do {
            menu.showMenu();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    manageFlightSchedules();
                    break;
                case 2:
                    getAllFlights();
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
            }
        } while (choice != 8 || !cont);
    }

    public static void manageFlightSchedules() {

        boolean check = true;

        System.out.println("Flight Schedule Management");
        System.out.println("Enter flight details:");

        String flightNumber = "";
        do {
            flightNumber = Utils.getString("Enter flight number: ");
            if (Utils.isNumber(flightNumber)) {
                check = false;
            } else {
                check = true;
                System.out.println("Flight number must be Fxxxx (x stands for a digit)!");
            }
        } while (check);
        String departureCity = Utils.getString("Enter departure city: ");
        String destinationCity = Utils.getString("Enter destination city: ");
        String departureTime = Utils.getString("Enter departure time: ");
        String arrivalTime = Utils.getString("Enter arrival time: ");
        int availableSeats = Utils.getInt("Enter available seats: ", 1, 100);

        //Create a new flight object
        Flight flight = new Flight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime, availableSeats);
        
        //Add the flight to the repository
        FlightService flightService = new FlightService();
        flightService.addFlight(flight);

        System.out.println("Flight added successfully!\n");
    }

    public static void getAllFlights() {
        FlightService flightService = new FlightService();
        List<Flight> flights = flightService.getAllFlight();
        System.out.println("Flight Schedule Management");
        System.out.println("List of all flights:");
        System.out.println("Flight number\tDeparture city\tDestination city\tDeparture time\tArrival time\tAvailable seats");
        for (Flight flight : flights) {
            System.out.println(flight.toString());
        }
    }
}
