package com.kodilla.good.patterns.foodToDoor.pojo;

import java.time.LocalDateTime;

public class DeliveryPlace {

    private String shopDetails;
    private LocalDateTime expectedDeliveryTime;

    public DeliveryPlace() {
    }

    public DeliveryPlace(String shopDetails, LocalDateTime expectedDeliveryTime) {
        this.shopDetails = shopDetails;
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public String getShopDetails() {
        return shopDetails;
    }

    public LocalDateTime getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    @Override
    public String toString() {
        return shopDetails + "\n" + "Expected Delivery Time: " + expectedDeliveryTime;
    }
}
