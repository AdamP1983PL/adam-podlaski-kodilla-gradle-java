package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.dto.ProductDto;
import com.kodilla.good.patterns.foodToDoor.mapper.ProductMapper;
import com.kodilla.good.patterns.foodToDoor.pojo.*;
import com.kodilla.good.patterns.foodToDoor.repository.ProductRepositoryImpl;
import com.kodilla.good.patterns.foodToDoor.service.OrderServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        ProductRepositoryImpl productRepositoryImpl = new ProductRepositoryImpl();
        productRepositoryImpl.showProductsBySupplier();

        Product orderedProducts1 = productRepositoryImpl.extraShopFood.getProducts().get(0);
        Product orderedProducts2 = productRepositoryImpl.extraShopFood.getProducts().get(1);
        FoodProducer extraShopFood = new FoodProducer("Extra Shop Food");

        Basket basket = new Basket();
        basket.addProductsToBasket(ProductMapper.mapToProductDto(orderedProducts1), new Quantity(5));
        basket.addProductsToBasket(ProductMapper.mapToProductDto(orderedProducts2), new Quantity(55));

        DeliveryPlace deliveryPlace = new DeliveryPlace("Katowice, Kościuszki 45/2",
                LocalDateTime.of(2023, 10, 23, 9, 15, 0));


        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.process(extraShopFood, basket, deliveryPlace);

        System.out.println("\n" + "x".repeat(60));

        orderService.process(new FoodProducer("New Food Producer...",
                new ArrayList<>(List.of(
                        new Product(123, "Product_a", 50, new BigDecimal("10000"), true)
                ))),
                new Basket(new ProductDto("Product_a", true),
                        new Quantity(5)),
                new DeliveryPlace("New Delivery Place Details...", LocalDateTime.of(2023, 10, 23, 12, 15,00)));
    }
}
