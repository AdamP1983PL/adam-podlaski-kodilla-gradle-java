package com.kodilla.patterns.enums.hotel;

import java.math.BigDecimal;

public enum Seasons {
    LOW(new BigDecimal(250), new BigDecimal(350)),
    HIGH(new BigDecimal(320), new BigDecimal(400)),
    HOLIDAY(new BigDecimal(300), new BigDecimal(500));

    private BigDecimal singleRoomPrice;
    private BigDecimal doubleRoomPrice;

    Seasons(BigDecimal singleRoomPrice, BigDecimal doubleRoomPrice) {
        this.singleRoomPrice = singleRoomPrice;
        this.doubleRoomPrice = doubleRoomPrice;
    }

    public BigDecimal getSingleRoomPrice() {
        return singleRoomPrice;
    }

    public BigDecimal getDoubleRoomPrice() {
        return doubleRoomPrice;
    }
}
