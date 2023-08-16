package com.kodilla.testing.shape;

public class Circle implements Shape{

    private String name;
    private double radius;
    public static final double pi = Math.PI;

    public Circle(String name, double radius) {
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return pi * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "name='" + name + '\'' +
                ", radius=" + radius +
                '}';
    }
}
