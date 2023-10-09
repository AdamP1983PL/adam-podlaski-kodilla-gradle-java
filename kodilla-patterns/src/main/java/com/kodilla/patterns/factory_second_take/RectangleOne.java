package com.kodilla.patterns.factory_second_take;

public class RectangleOne implements ShapeOne{

    private final String name;
    private final double width;
    private final double length;

    public RectangleOne(final String name, final double width, final double length){
        this.name = name;
        this.width = width;
        this.length = length;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getCircumference() {
        return 2 * (width + length);
    }
}
