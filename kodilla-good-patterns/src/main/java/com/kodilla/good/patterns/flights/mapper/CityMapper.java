package com.kodilla.good.patterns.flights.mapper;

import com.kodilla.good.patterns.flights.dto.CityDto;
import com.kodilla.good.patterns.flights.pojo.City;

public class CityMapper {

    public static CityDto mapToCityDto(City city){
        return new CityDto(city.getName());
    }
}
