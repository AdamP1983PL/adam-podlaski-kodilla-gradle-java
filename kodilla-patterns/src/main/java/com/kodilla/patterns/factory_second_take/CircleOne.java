package com.kodilla.patterns.factory_second_take;

public final class CircleOne implements ShapeOne {

    private final String name;
    private final double radius;

    public CircleOne(final String name, final double radius) {
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
