package com.kodilla.testing.shape;

public class Triangle implements Shape{

    private String name;
    private int base;
    private int height;

    public Triangle(String name, int base, int height) {
        this.name = name;
        this.base = base;
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return name + ":" + base + ":" + height;
    }
}
