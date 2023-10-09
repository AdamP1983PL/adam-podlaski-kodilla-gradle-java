package com.kodilla.patterns.factory_second_take;

public final class ShapeFactoryOne {

    public static final String CIRCLE = "CIRCLE";
    public static final String SQUARE = "SQUARE";
    public static final String RECTANGLE = "RECTANGLE";

    public ShapeOne makeShapeOne(final String shapeClass) {
        return switch (shapeClass) {
            case CIRCLE -> new CircleOne("The rounded circle", 4.50);
            case SQUARE -> new SquareOne("The angular square", 7.00);
            case RECTANGLE -> new RectangleOne("The long rectangle", 15.0, 2.5);
            default -> throw new UnsupportedOperationException("No such object");
        };
    }
}
