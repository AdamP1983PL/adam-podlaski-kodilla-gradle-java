package com.kodilla.good.patterns.foodToDoor.service;

import com.kodilla.good.patterns.foodToDoor.Basket;
import com.kodilla.good.patterns.foodToDoor.pojo.DeliveryPlace;
import com.kodilla.good.patterns.foodToDoor.pojo.FoodProducer;

public interface OrderService {

    void process(FoodProducer foodProducer, Basket basket,
                 DeliveryPlace deliveryPlace);
}
