package com.kodilla.testing.shape;

public class Circle implements Shape{

    private double radius;
    static final double pi = Math.PI;

    public double getRadius() {
        return radius;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public double getField() {
        return 2 * pi * radius;
    }
}
