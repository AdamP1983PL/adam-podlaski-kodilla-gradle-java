package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuit {

    @Nested
    @DisplayName("Adding and removing single element tests.")
    class SubTests1{
        @Test
        void afterAddingElementTheCollectionSizeShouldIncreaseByOne() {
            //given
            List<Shape> shapes = new ArrayList<>();
            ShapeCollector shapeCollector = new ShapeCollector(shapes);
            Shape shape1 = new Circle("Circle1", 1.0);

            //when
            shapeCollector.addFigure(shape1);

            //then
            assertEquals(1, shapes.size());
            assertEquals(shape1, shapes.get(0));
            assertEquals("Circle1", shapes.get(0).getShapeName());
        }

        @Test
        void afterRemovingElementFromTheCollectionSizeShouldDecreaseByOne() {

            //given
            List<Shape> shapes = new ArrayList<>();
            ShapeCollector shapeCollector = new ShapeCollector(shapes);
            Shape shape = new Circle("Circle", 1.0);
            shapeCollector.addFigure(shape);

            //when
            shapeCollector.removeFigure(shape);
            List<Shape> expectedList = new ArrayList<>();

            //then
            assertEquals(expectedList, shapes);
            assertEquals(0, shapes.size());
        }
    }

    @Nested
    @DisplayName("Getting one or all elements from the Collection tests.")
    class SubTests2 {

        @Test
        void shouldReturnGivenElementFromTheCollection() {
            //given
            List<Shape> shapes = new ArrayList<>();
            ShapeCollector shapeCollector = new ShapeCollector(shapes);
            Shape shape = new Circle("Circle1", 1.0);
            shapeCollector.addFigure(shape);


            //when
            Shape temp = shapeCollector.getFigure(0);
            String tempName = shapes.get(0).getShapeName();
            String expected = "Circle1";

            //then
            assertEquals(shape, temp);
            assertEquals(expected, tempName);

        }

        @Test
        void testShowFigure() {
            //given
            List<Shape> shapes = new ArrayList<>();
            ShapeCollector shapeCollector = new ShapeCollector(shapes);
            Shape shape = new Square("Square1", 1.0);
            Shape shape2 = new Square("Square2", 1.0);
            shapeCollector.addFigure(shape);
            shapeCollector.addFigure(shape2);

            //when
            String temp = shapeCollector.showFigures();
            String expected = "square1:1.0,square2:1.0,";

            //then
            assertEquals(expected, temp);
        }
    }
}
