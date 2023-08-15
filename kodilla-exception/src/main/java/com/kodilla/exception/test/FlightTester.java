package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightTester {
    Map<String, Boolean> arrivalIsAccessible;

    public FlightTester(){
        arrivalIsAccessible = new HashMap<>();
        arrivalIsAccessible.put("Katowice", true);
        arrivalIsAccessible.put("Kraków", false);
        arrivalIsAccessible.put("Wrocław", true);
    }

    public void findFlight(Flight flight) throws RouteNotFoundException {

        String arrivalAirport = flight.getArrivalAirport();
        if (arrivalIsAccessible.containsKey(arrivalAirport)){
            System.out.println("The Airport \"" + arrivalAirport + "\" is accessible from this location.");
        } else {
            throw new RouteNotFoundException("The Airport \"" + arrivalAirport + "\" is not accessible from this location ");
        }
    }


    public static void main(String[] args)  {
        FlightTester flightTester = new FlightTester();
        Flight toKatowice = new Flight("Warszawa", "Katowice");
        Flight toLondyn = new Flight("Warszawa", "Londyn");

        try {
            flightTester.findFlight(toKatowice);
        } catch (RouteNotFoundException e) {
            System.out.println("Arrival Airport not accessible. " + e.getMessage());
        }

        try {
            flightTester.findFlight(toLondyn);
        } catch (RouteNotFoundException e) {
            System.out.println("Not accessible. " + e.getMessage());
        }
    }
}

