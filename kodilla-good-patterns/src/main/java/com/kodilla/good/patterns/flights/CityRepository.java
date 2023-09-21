package com.kodilla.good.patterns.flights;

import java.util.ArrayList;
import java.util.List;

public class CityRepository {

    public List<City> create(City city) {
        List<City> cities = new ArrayList<>();
        cities.add(new City());
        return cities;
    }

}
