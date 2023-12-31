package com.kodilla.testing.shape;

public class Circle implements Shape{

    private String name;
    private double radius;
    static final double PI = Math.PI;

    public Circle(String name, double radius) {
        this.name = name;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return name + ":" + radius;
    }
}
