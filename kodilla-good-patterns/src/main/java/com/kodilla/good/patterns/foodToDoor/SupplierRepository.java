package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.pojo.FoodProducer;
import com.kodilla.good.patterns.foodToDoor.pojo.Product;

import java.util.List;

public interface SupplierRepository {

    void showDetails(FoodProducer foodProducer);

    List<Product> showSupplierProductsList(FoodProducer foodProducer);

    void addSupplier(List<FoodProducer> foodProducerList);

    public Product getProductFromSupplier();
}
