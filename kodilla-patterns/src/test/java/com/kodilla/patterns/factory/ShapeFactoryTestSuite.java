package com.kodilla.patterns.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeFactoryTestSuite {

    @Test
    void testFactoryCircle() {
        // given
        ShapeFactory factory = new ShapeFactory();

        // when
        Shape circle = factory.makeShape(ShapeFactory.CIRCLE);

        // then
        assertEquals(Math.PI * Math.pow(4.50, 2.0), circle.getArea(), 0);
        assertEquals("The rounded circle", circle.getName());
    }

    @Test
    void testFactoryRectangle() {
        // given
        ShapeFactory factory = new ShapeFactory();

        // when
        Shape rectangle = factory.makeShape(ShapeFactory.RECTANGLE);

        // then
        assertEquals(37.50, rectangle.getArea(), 0);
        assertEquals("The long rectangle", rectangle.getName());
    }

    @Test
    void testFactorySquare() {
        // given
        ShapeFactory factory = new ShapeFactory();

        // when
        Shape square = factory.makeShape(ShapeFactory.SQUARE);

        // then
        assertEquals(49.0, square.getArea());
        assertEquals("The angular square", square.getName());
        assertEquals(28.0, square.getCircumference(), 0);
    }
}
