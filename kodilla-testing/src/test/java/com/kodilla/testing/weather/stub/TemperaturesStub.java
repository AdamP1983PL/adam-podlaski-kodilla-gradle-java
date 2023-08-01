package com.kodilla.testing.weather.stub;

import com.kodilla.testing.stub.Temperatures;

import java.util.HashMap;
import java.util.Map;

public class TemperaturesStub implements Temperatures {

    @Override
    public Map<String, Double> getTemperatures() {
        Map<String, Double> stubResult = new HashMap<>();

        stubResult.put("Ćwiklice", 25.5);
        stubResult.put("Studzionka", 26.2);
        stubResult.put("Poręba", 24.8);
        stubResult.put("Kryry", 25.2);
        stubResult.put("Kobielice", 26.1);

        return stubResult;
    }
}
