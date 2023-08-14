package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightTester {

    public Map<String, Boolean> findFlight(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> arrivalIsAccessible = new HashMap<>();
        arrivalIsAccessible.put("Katowice", true);
        arrivalIsAccessible.put("Kraków", false);
        arrivalIsAccessible.put("Wrocław", true);

        if (flight.getArrivalAirport().equals("Katowice") ||
                flight.getArrivalAirport().equals("Wrocław")) {
            System.out.println("The Airport " + flight.getArrivalAirport() + " is accessible from this location.");
        } else {
            throw new RouteNotFoundException("The Airport " + flight.getArrivalAirport() + " is not accessible from this location ");
        }
        return arrivalIsAccessible;
    }


    public static void main(String[] args) throws RouteNotFoundException {
        FlightTester flightTester = new FlightTester();

        Flight toKatowice = new Flight("Warszawa", "Katowice");
        flightTester.findFlight(toKatowice);

        Flight toWroclaw = new Flight("Warszawa", "Wrocław");
        flightTester.findFlight(toWroclaw);

        Flight toKrakow = new Flight("Warszawa", "Kraków");
        flightTester.findFlight(toKrakow);
    }
}
