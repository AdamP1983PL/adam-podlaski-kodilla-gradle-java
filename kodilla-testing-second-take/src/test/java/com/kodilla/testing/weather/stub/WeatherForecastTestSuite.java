package com.kodilla.testing.weather.stub;

import org.junit.jupiter.api.Test;
import weather.stub.Temperatures;
import weather.stub.WeatherForecast;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherForecastTestSuite {

    @Test
    void testCalculateForecastWithStub(){
        //given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);

        //when
        int qualityOfSensors = weatherForecast.calculateForecast().size();

        //then
        assertEquals(5, qualityOfSensors);
    }


}
