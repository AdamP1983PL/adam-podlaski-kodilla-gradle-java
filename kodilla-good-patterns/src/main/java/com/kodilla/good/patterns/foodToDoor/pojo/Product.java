package com.kodilla.good.patterns.foodToDoor.pojo;

import java.math.BigDecimal;

public class Product {

    private int index;
    private String name;
    private int quantity;
    private BigDecimal price;
    private boolean isAvailable;

    public Product() {
    }

    public Product(int index) {
        this.index = index;
    }

    public Product(int id, String name, int quantity, BigDecimal price, boolean isAvailable) {
        this.index = index;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
