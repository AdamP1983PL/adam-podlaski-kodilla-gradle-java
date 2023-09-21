package com.kodilla.good.patterns.foodToDoor;

import com.kodilla.good.patterns.foodToDoor.dto.ProductDto;
import com.kodilla.good.patterns.foodToDoor.pojo.Quantity;

import java.util.HashMap;
import java.util.Map;

public class Basket {

    private ProductDto productDto;
    private Quantity quantity;
    Map<ProductDto, Quantity> products = new HashMap<>();

    public Basket() {
    }

    public Basket(ProductDto productDto, Quantity quantity) {
        this.productDto = productDto;
        this.quantity = quantity;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void addProductsToBasket(ProductDto productDto, Quantity quantity) {
        products.put(productDto, quantity);
    }

    public void getBasket() {
        for (Map.Entry<ProductDto, Quantity> entry : products.entrySet()) {
            ProductDto productDto = entry.getKey();
            Quantity quantity = entry.getValue();
            System.out.println("Product: " + productDto + ", Quantity: " + quantity);
        }
    }
}
