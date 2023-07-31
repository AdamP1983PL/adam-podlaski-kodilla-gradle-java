package com.kodilla.testing.shape;

public class Square implements Shape{

    private int sideLength;

    public int getSideLength() {
        return sideLength;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        return sideLength * sideLength;
    }
}
