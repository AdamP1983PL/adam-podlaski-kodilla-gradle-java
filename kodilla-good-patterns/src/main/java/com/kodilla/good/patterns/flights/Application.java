package com.kodilla.good.patterns.flights;

import com.kodilla.good.patterns.flights.dto.CityDto;
import com.kodilla.good.patterns.flights.mapper.CityMapper;
import com.kodilla.good.patterns.flights.pojo.City;
import com.kodilla.good.patterns.flights.pojo.Flight;
import com.kodilla.good.patterns.flights.repository.FlightRepository;
import com.kodilla.good.patterns.flights.service.FlightServiceImpl;

public class Application {
    public static void main(String[] args) {

        City warszawa = new City(1, "Warszawa", true, false, false);
        City krakow = new City(2, "Kraków", true, false, false);
        City poznan = new City(3, "Poznań", false, true, false);
        City gdansk = new City(4, "Gdańsk", false, true, false);
        City katowice = new City(5, "Katowice", false, false, true);
        City szczecin = new City(6, "Szczecin", false, false, true);

        CityDto warszawaDto = CityMapper.mapToCityDto(warszawa);
        CityDto krakowDto = CityMapper.mapToCityDto(krakow);
        CityDto poznanDto = CityMapper.mapToCityDto(poznan);
        CityDto gdanskDto = CityMapper.mapToCityDto(gdansk);
        CityDto katowiceDto = CityMapper.mapToCityDto(katowice);
        CityDto szczecinDto = CityMapper.mapToCityDto(szczecin);

        Flight flight1 = new Flight(1, warszawaDto, poznanDto);
        Flight flight2 = new Flight(2, warszawaDto, gdanskDto);
        Flight flight3 = new Flight(3, warszawaDto, poznanDto, katowiceDto);
        Flight flight4 = new Flight(4, krakowDto, poznanDto, katowiceDto);
        Flight flight5 = new Flight(5, warszawaDto, gdanskDto, szczecinDto);

        FlightRepository flightRepository = new FlightRepository();

        FlightServiceImpl flightServiceImpl = new FlightServiceImpl();
        flightServiceImpl.addFlight(flight1);
        flightServiceImpl.addFlight(flight2);
        flightServiceImpl.addFlight(flight3);
        flightServiceImpl.addFlight(flight4);
        flightServiceImpl.addFlight(flight5);

        /*
        DESTINATION CITIES: Warszawa, Kraków
        DEPARTURE CITIES: Poznań, Gdańsk
        THROUGH CITY: Katowice, Szczecin
        */

        System.out.println("\nFind all flights: ");
        System.out.println(flightServiceImpl.showAllFlights());

        System.out.println("\nFind all flights by Destination: Warszawa ");
        System.out.println(flightServiceImpl.findAllFlightsByDestination(warszawa));

        System.out.println("\nFind all flights by Destination: Poznań ");
        System.out.println(flightServiceImpl.findAllFlightsByDestination(poznan));

        System.out.println("\nFind all flights by Departure: Poznań ");
        System.out.println(flightServiceImpl.findAllFlightsByDeparture(poznan));

        System.out.println("\nFind all flights To: Warszawa, From: Poznań, Through: Katowice:");
        System.out.println(flightServiceImpl.findAllFlightsToFromThrough(warszawa, poznan, katowice));

        System.out.println("\nFind all flights To: Warszawa, From: Gdańsk, Through: Szczecin:");
        System.out.println(flightServiceImpl.findAllFlightsToFromThrough(warszawa, gdansk, szczecin));
    }
}
