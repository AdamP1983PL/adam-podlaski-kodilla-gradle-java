package com.kodilla.good.patterns.foodToDoor.pojo;

import java.util.List;

public class FoodProducer {

    private String companyName;
    private List<Product> products;

    public FoodProducer() {
    }

    public FoodProducer(String companyName, List<Product> products) {
        this.companyName = companyName;
        this.products = products;
    }

    public FoodProducer(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "FoodProducer{companyName='" + companyName + '\'' + '}';
    }
}
