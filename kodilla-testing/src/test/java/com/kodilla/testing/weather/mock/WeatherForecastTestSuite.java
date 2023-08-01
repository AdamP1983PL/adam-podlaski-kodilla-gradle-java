package com.kodilla.testing.weather.mock;

import com.kodilla.testing.stub.Temperatures;
import com.kodilla.testing.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    @Mock
    private Temperatures temperaturesMock;
    private WeatherForecast weatherForecast;

    @BeforeEach
    void prepareData(){
        temperaturesMock = mock(Temperatures.class);
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Ćwiklice", 25.0);
        temperaturesMap.put("Studzionka", 26.0);
        temperaturesMap.put("Poręba", 24.0);
        temperaturesMap.put("Kryry", 25.0);
        temperaturesMap.put("Kobielice", 26.0);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        weatherForecast = new WeatherForecast(temperaturesMock);
    }

    @Test
    void testCalculateForecastSuite(){
        //given
        //@BeforeEach prepareData()


        //when
        int qualityOfSensors = weatherForecast.calculateForecast().size();

        //then
        Assertions.assertEquals(5, qualityOfSensors);
    }

    @Test
    void testCalculateAverageTempSuite(){
        //given
        //@BeforeEach prepareData()

        //when
        double tempAverageTemperature = weatherForecast.averageTemp();

        //then
        Assertions.assertEquals(25.2, tempAverageTemperature);
    }

    @Test
    void testCalculateMedianTempSuite(){
        //given
        //@BeforeEach prepareData()

        //when
        double tempMedianTemperature = weatherForecast.medianTemp();

        //then
        Assertions.assertEquals(25.0, tempMedianTemperature);
    }


}
