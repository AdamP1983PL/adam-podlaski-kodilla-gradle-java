package com.kodilla.patterns.factory_second_take;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeFactoryTestSuiteOne {

    @Test
    void testFactoryCircleOne() {
        // given
        ShapeFactoryOne factoryOne = new ShapeFactoryOne();

        // when
        ShapeOne circle = factoryOne.makeShapeOne(ShapeFactoryOne.CIRCLE);

        // then
        assertEquals(Math.PI * Math.pow(4.50, 2.0), circle.getArea(), 0);
        assertEquals("The rounded circle", circle.getName());
    }

    @Test
    void testFactorRectangleOne(){
        // given
        ShapeFactoryOne shapeFactoryOne = new ShapeFactoryOne();

        // when
        ShapeOne squareOne = shapeFactoryOne.makeShapeOne(ShapeFactoryOne.SQUARE);

        // then
        assertEquals(28.0, squareOne.getCircumference(), 0);
        assertEquals("The angular square", squareOne.getName());
    }
}
