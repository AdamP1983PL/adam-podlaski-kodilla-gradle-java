package com.kodilla.testing.shape;

public class Triangle implements Shape{

    private int base;
    private int height;

    public Triangle(int base, int height) {
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
        return "Triangle";
    }

    @Override
    public double getField() {
        return 0.5 * base * height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (base != triangle.base) return false;
        return height == triangle.height;
    }

    @Override
    public int hashCode() {
        int result = base;
        result = 31 * result + height;
        return result;
    }
}
