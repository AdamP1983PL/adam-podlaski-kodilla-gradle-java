package com.kodilla.patterns.enums.hotel;

import java.math.BigDecimal;
import java.util.Map;

public class PriceList {

    private static Map<Seasons, BigDecimal> singleBedPrices = Map.of(
            Seasons.LOW, new BigDecimal(250),
            Seasons.HIGH, new BigDecimal(320),
            Seasons.HOLIDAY, new BigDecimal(400)
    );

    private static Map<Seasons, BigDecimal> doubleBedPrices = Map.of(
            Seasons.LOW, new BigDecimal(350),
            Seasons.HIGH, new BigDecimal(400),
            Seasons.HOLIDAY, new BigDecimal(500)
    );

    public static BigDecimal getSingleBedPrice(Seasons season) {
        return singleBedPrices.get(season);
    }

    public static BigDecimal getDoubleBedPrice(Seasons season) {
        return doubleBedPrices.get(season);
    }
}
