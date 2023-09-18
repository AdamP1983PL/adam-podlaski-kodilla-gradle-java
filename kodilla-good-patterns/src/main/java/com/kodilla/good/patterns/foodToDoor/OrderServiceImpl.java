package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.pojo.Basket;
import com.kodilla.good.patterns.foodToDoor.pojo.DeliveryPlace;
import com.kodilla.good.patterns.foodToDoor.pojo.FoodProducer;

public class OrderServiceImpl implements OrderService {

    @Override
    public void process(FoodProducer foodProducer, Basket basket,
                        DeliveryPlace deliveryPlace) {

        System.out.println("\nOrder details: \n");
        System.out.println("Delivery Company: " + foodProducer.getCompanyName());
        System.out.println("Ordered Products: ");
        basket.getBasket();
        System.out.println("Delivery place: " + deliveryPlace);
    }
}
