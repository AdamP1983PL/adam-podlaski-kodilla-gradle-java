package com.kodilla.good.patterns.foodToDoor.pojo;

public class Quantity {

    private int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    public Quantity() {
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return quantity + ".";
    }
}
