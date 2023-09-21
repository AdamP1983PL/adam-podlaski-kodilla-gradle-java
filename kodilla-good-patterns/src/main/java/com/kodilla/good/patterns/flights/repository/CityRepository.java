package com.kodilla.good.patterns.flights.repository;

import com.kodilla.good.patterns.flights.pojo.City;

import java.util.ArrayList;
import java.util.List;

public class CityRepository {

    public List<City> create(City city) {
        List<City> cities = new ArrayList<>();
        cities.add(new City());
        return cities;
    }

}
