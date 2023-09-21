package com.kodilla.good.patterns.flights;

public class CityMapper {

    public static CityDto mapToCityDto(City city){
        return new CityDto(city.getName());
    }
}
