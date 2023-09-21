package com.kodilla.good.patterns.flights;

import java.util.Objects;

public class FlightDto {

    private City city;

    public FlightDto() {
    }

    public FlightDto(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "FlightDto{" +
                "city=" + city +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightDto flightDto = (FlightDto) o;

        return Objects.equals(city, flightDto.city);
    }

    @Override
    public int hashCode() {
        return city != null ? city.hashCode() : 0;
    }
}
