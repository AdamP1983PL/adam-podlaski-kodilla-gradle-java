package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.pojo.FoodProducer;
import com.kodilla.good.patterns.foodToDoor.pojo.Product;

public interface ProductsRepository {

    void showProductsBySupplier();

    Product getProduct(FoodProducer foodProducer);
}
