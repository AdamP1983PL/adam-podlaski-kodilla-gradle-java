package com.kodilla.good.patterns.flights;

import java.util.Objects;

public class City {

    private int id;
    private String name;
    private boolean destCity;
    private boolean departCity;
    private boolean throughCity;

    public City() {
    }

    public City(int id, String name, boolean destCity, boolean departCity, boolean throughCity) {
        this.id = id;
        this.name = name;
        this.destCity = destCity;
        this.departCity = departCity;
        this.throughCity = throughCity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isDestCity() {
        return destCity;
    }

    public boolean isDepartCity() {
        return departCity;
    }

    public boolean isThroughCity() {
        return throughCity;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", toCity=" + destCity +
                ", fromCity=" + departCity +
                ", throughCity=" + throughCity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (id != city.id) return false;
        if (destCity != city.destCity) return false;
        if (departCity != city.departCity) return false;
        if (throughCity != city.throughCity) return false;
        return Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (destCity ? 1 : 0);
        result = 31 * result + (departCity ? 1 : 0);
        result = 31 * result + (throughCity ? 1 : 0);
        return result;
    }
}
