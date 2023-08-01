package com.kodilla.testing.weather.stub;

import com.kodilla.testing.stub.Temperatures;
import com.kodilla.testing.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WeatherForecastTestSuite {

    @Test
    void testCalculateForecastWithStub(){
         //given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);

        //when
        int qualityOfSensors = weatherForecast.calculateForecast().size();

        //then
        Assertions.assertEquals(5, qualityOfSensors);
    }
}
