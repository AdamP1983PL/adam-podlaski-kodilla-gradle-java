package com.kodilla.good.patterns.flights;

import java.util.Objects;

public class Flight {

    private int flightId;
    private CityDto to;
    private CityDto from;
    private CityDto through;

    public Flight() {
    }

    public Flight(int flightId, CityDto to, CityDto from) {
        this.flightId = flightId;
        this.to =  to;
        this.from = from;
    }

    public Flight(int flightId, CityDto to, CityDto from, CityDto through) {
        this.flightId = flightId;
        this.to = to;
        this.from = from;
        this.through = through;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public CityDto getTo() {
        return to;
    }

    public void setTo(CityDto to) {
        this.to = to;
    }

    public CityDto getFrom() {
        return from;
    }

    public void setFrom(CityDto from) {
        this.from = from;
    }

    public CityDto getThrough() {
        return through;
    }

    public void setThrough(CityDto through) {
        this.through = through;
    }

    @Override
    public String toString() {
        return "Flight: " + "Destination: " + to + ", Departure: " + from + ", through: " + through + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (flightId != flight.flightId) return false;
        if (!Objects.equals(to, flight.to)) return false;
        if (!Objects.equals(from, flight.from)) return false;
        return Objects.equals(through, flight.through);
    }

    @Override
    public int hashCode() {
        int result = flightId;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (from != null ? from.hashCode() : 0);
        result = 31 * result + (through != null ? through.hashCode() : 0);
        return result;
    }
}
