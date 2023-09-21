package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.pojo.FoodProducer;
import com.kodilla.good.patterns.foodToDoor.pojo.Product;

import java.util.List;

public class SupplierRepositoryImpl implements SupplierRepository {

    ProductRepositoryImpl productRepository;

    @Override
    public void showDetails(FoodProducer foodProducer) {
        System.out.println("Company name: " + foodProducer.getCompanyName());
        System.out.println("Products: " + foodProducer.getProducts().stream().toList());
    }

    @Override
    public void addSupplier(List<FoodProducer> foodProducerList) {
        foodProducerList.add(new FoodProducer());
    }

    @Override
    public List<Product> showSupplierProductsList(FoodProducer foodProducer) {
        return foodProducer.getProducts().stream().toList();
    }

    @Override
    public Product getProductFromSupplier() {
        return null;
    }


}
