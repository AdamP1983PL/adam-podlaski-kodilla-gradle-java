package com.kodilla.good.patterns.flights;

import java.util.List;

public interface FlightService {

    List<Flight> findAllFlightsByDestination(City destinationCity);

    List<Flight> findAllFlightsByDeparture(City departureCity);

    List<Flight> findAllFlightsToFromThrough(City destinationCity, City departureCity, City throughCity);

    List<Flight> addFlight(Flight flight);

    List<Flight> showAllFlights();

}
