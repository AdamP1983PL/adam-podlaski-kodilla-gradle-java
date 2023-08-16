package com.kodilla.testing.shape;

public class Square implements Shape{
    private String name;
    private double base;

    public Square(String name, double base) {
        this.name = name;
        this.base = base;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return base * base;
    }

    @Override
    public String toString() {
        return name + ":" + base;
    }
}
