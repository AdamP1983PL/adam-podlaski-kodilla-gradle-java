package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.pojo.FoodProducer;
import com.kodilla.good.patterns.foodToDoor.pojo.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductsRepository {

    Product product1 = new Product(0, "extraFood1", 50, new BigDecimal("20.0"), true);
    Product product2 = new Product(1, "extraFood2", 100, new BigDecimal("40.0"), true);
    Product product3 = new Product(2, "extraFood3", 150, new BigDecimal("80.0"), true);
    Product product4 = new Product(3, "extraFood4", 200, new BigDecimal("160.0"), true);
    FoodProducer extraShopFood = new FoodProducer("Extra Shop Food",
            new ArrayList<>(List.of(product1, product2, product3, product4)));


    Product product1a = new Product(0, "healthyShop1", 0, new BigDecimal("8.0"), true);
    Product product2a = new Product(1, "healthyShop2", 1000, new BigDecimal("16.0"), false);
    Product product3a = new Product(2, "healthyShop3", 1000, new BigDecimal("31.0"), true);
    Product product4a = new Product(3, "healthyShop4", 0, new BigDecimal("64.0"), false);
    FoodProducer healthyShop = new FoodProducer("Healthy Shop");

    Product product1b = new Product(0, "glutenFree1", 0, new BigDecimal("3"), false);
    Product product2b = new Product(1, "glutenFree2", 10000, new BigDecimal("6"), true);
    Product product3b = new Product(2, "glutenFree3", 10, new BigDecimal("9"), true);
    Product product4b = new Product(3, "glutenFree4", 0, new BigDecimal("18"), false);
    FoodProducer glutenFreeSHop = new FoodProducer("Gluten Free Shop");


    @Override
    public void showProductsBySupplier() {
        Map<FoodProducer, List<Product>> productsBySupplier = new HashMap<>();
        productsBySupplier.put(extraShopFood, List.of(product1, product2, product3, product4));
        productsBySupplier.put(healthyShop, List.of(product1a, product2a, product3a, product4a));
        productsBySupplier.put(glutenFreeSHop, List.of(product1b, product2b, product3b, product4b));

        productsBySupplier.forEach((supplier, products) -> {
            System.out.println("\nSupplier: " + supplier);

            products.forEach(product -> {
                System.out.println("Product: " + product);
            });
        });
    }
}
