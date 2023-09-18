package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.pojo.Basket;
import com.kodilla.good.patterns.foodToDoor.pojo.DeliveryPlace;
import com.kodilla.good.patterns.foodToDoor.pojo.FoodProducer;

public interface OrderService {

    void process(FoodProducer foodProducer, Basket basket,
                 DeliveryPlace deliveryPlace);
}
