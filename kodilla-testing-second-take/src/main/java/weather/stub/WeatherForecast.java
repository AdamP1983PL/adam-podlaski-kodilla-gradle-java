package weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast(){
        Map<String, Double> resultMap = new HashMap<>();

        for(Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()){
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverage(){
        Collection<Double> tempTemperatures = temperatures.getTemperatures().values();
        double temp = 0;
        for (Double temperature : tempTemperatures){
            temp +=temperature;
        }
        return temp/tempTemperatures.size();
    }

    public double medianTemp(){
        double median;
        Collection<Double> tempTemperatures = temperatures.getTemperatures().values();
        List<Double> tempTemperaturesList = new ArrayList<>(tempTemperatures);
        Collections.sort(tempTemperaturesList);

        int n = tempTemperaturesList.size();
        if (tempTemperaturesList.size() % 2 == 0) {
            double temp1 = tempTemperaturesList.get((n / 2) - 1);
            System.out.println("temp1: " + temp1);

            double temp2 = tempTemperaturesList.get((n / 2));
            System.out.println("temp2: " + temp2);

            median = (temp1 + temp2) / 2;
            System.out.println("median: " + median);

        } else {
            median = tempTemperaturesList.get(n / 2);
            System.out.println("median: " + median);
        }
        return median;
    }

}
