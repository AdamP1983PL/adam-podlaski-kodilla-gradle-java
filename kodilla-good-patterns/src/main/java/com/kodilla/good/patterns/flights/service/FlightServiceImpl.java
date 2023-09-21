package com.kodilla.good.patterns.flights.service;

import com.kodilla.good.patterns.flights.mapper.CityMapper;
import com.kodilla.good.patterns.flights.pojo.City;
import com.kodilla.good.patterns.flights.pojo.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightServiceImpl implements FlightService {

    List<Flight> flightRepositories = new ArrayList<>();

    @Override
    public List<Flight> findAllFlightsByDestination(City city) {
        if (city.isDestCity()) {
            return flightRepositories.stream()
                    .filter(flight -> flight.getTo().equals(CityMapper.mapToCityDto(city)))
                    .toList();
        }
            return null;
    }

    @Override
    public List<Flight> findAllFlightsByDeparture(City city) {
        if(city.isDepartCity()){
            return flightRepositories.stream()
                    .filter(flight -> flight.getFrom().equals(CityMapper.mapToCityDto(city)))
                    .toList();
        }
        return null;
    }

    @Override
    public List<Flight> findAllFlightsToFromThrough(City destinationCity, City departureCity, City throughCity) {
        if(destinationCity.isDestCity() && departureCity.isDepartCity()  && throughCity.isThroughCity()){
            return flightRepositories.stream()
                    .filter(flight -> flight.getThrough() != null)
                    .filter(flight -> flight.getTo().equals(CityMapper.mapToCityDto(destinationCity)))
                    .filter(flight -> flight.getFrom().equals(CityMapper.mapToCityDto(departureCity)))
                    .filter(flight -> flight.getThrough().equals(CityMapper.mapToCityDto(throughCity)))
                    .toList();
        }
        return null;
    }


    @Override
    public List<Flight> addFlight(Flight flight) {
        flightRepositories.add(flight);
        return flightRepositories;
    }

    @Override
    public List<Flight> showAllFlights() {
        return flightRepositories;
    }
}
