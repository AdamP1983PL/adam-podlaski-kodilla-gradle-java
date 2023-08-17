package com.kodilla.testing.weather.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import weather.stub.Temperatures;
import weather.stub.WeatherForecast;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;

    @BeforeEach
    void prepareData(){
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);                                      // [15]
        temperaturesMap.put("Krakow", 26.2);                                       // [16]
        temperaturesMap.put("Wroclaw", 24.8);                                      // [17]
        temperaturesMap.put("Warszawa", 25.2);                                     // [18]
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Test
    void testCalculateWeatherForecastWithMock(){
        //given
        //prepareData()

        //when
        int qualityOfSensors = weatherForecast.calculateForecast().size();

        //then
        assertEquals(5, qualityOfSensors);
    }

    @Test
    void testCalculateAverageWithMock(){
        //given
        //prepareData()

        //when
        double tempAverageTemperature = weatherForecast.calculateAverage();
        double expectedAverageTemperature = 25.56;

        //then
        assertEquals(expectedAverageTemperature, tempAverageTemperature);
    }

    @Test
    void testCalculateMedianWithMock(){
        //given
        //prepareData()

        //when
        double tempMedianTemperature = weatherForecast.medianTemp();
        double expectedMedianTemperature = 25.5;

        //then
        assertEquals(expectedMedianTemperature, tempMedianTemperature);


    }



























}
