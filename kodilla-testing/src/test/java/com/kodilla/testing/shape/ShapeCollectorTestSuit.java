package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuit {

    @Nested
    @DisplayName("Adding and removing single element tests.")
    class OneElementOperationsTests {
        @Test
        void afterAddingElementTheCollectionSizeShouldIncreaseByOne() {

            //given
            List<Shape> shapes = new ArrayList<>();
            ShapeCollector shapeCollector = new ShapeCollector(shapes);
            Circle circle = new Circle(2);

            //when
            shapeCollector.addFigure(circle);

            //then
            Assertions.assertEquals(1, shapeCollector.getShapes().size());
        }

        @Test
        void afterRemovingElementFromTheCollectionSizeShouldDecreaseByOne() {

            //given
            List<Shape> shapes = new ArrayList<>();
            ShapeCollector shapeCollector = new ShapeCollector(shapes);
            Circle circle = new Circle(2);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(circle);

            //when
            shapeCollector.removeFigure(circle);

            //then
            Assertions.assertEquals(1, shapeCollector.getShapes().size());
        }
    }

    @Nested
    @DisplayName("Getting one or all elements from the Collection tests.")
    class GettingElementsFromTheCollectionTests {


        @Test
        void shouldReturnGivenElementFromTheCollection() {

            //given
            List<Shape> shapes = new ArrayList<>();
            ShapeCollector shapeCollector = new ShapeCollector(shapes);
            Circle circle = new Circle(1);
            Circle circle1 = new Circle(1);
            Circle circle2 = new Circle(1);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(circle1);
            shapeCollector.addFigure(circle2);

            //when
            Shape temp = shapeCollector.getFigure(1);

            //then
            Assertions.assertEquals(circle1, temp);

        }

        @Test
        void numberOfReturnedElementsShouldBeEqualToCollectionSize() {

            //given
            List<Shape> shapes = new ArrayList<>();
            ShapeCollector shapeCollector = new ShapeCollector(shapes);
            Circle circle = new Circle(1);
            Circle circle1 = new Circle(1);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(circle1);

            //when
            shapeCollector.showFigures();

            //then
            Assertions.assertEquals(shapeCollector.getShapes().size(), shapeCollector.showFigures());
            /*
             * zmieniłem typ zwracany z void na int w metodzie showFigures() klasy ShapeCollector:
             *     public void showFigures(){} -> public int showFigures(){return -1}
             * */
        }
    }
}
