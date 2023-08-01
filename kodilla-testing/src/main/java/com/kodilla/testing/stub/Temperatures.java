package com.kodilla.testing.stub;

import java.util.Map;

public interface Temperatures {

    // first element -> identifier of weather station
    // second element -> temperature in "C"
    Map<String, Double> getTemperatures();

}
