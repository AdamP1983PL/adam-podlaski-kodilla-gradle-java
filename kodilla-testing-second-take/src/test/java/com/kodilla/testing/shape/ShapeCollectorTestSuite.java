package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    private static int counter = 0;

    @BeforeAll
    static void beforeAll(){
        System.out.println("@BeforeAll, start of all tests:");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("@AfterAll, end of all tests");
    }

    @BeforeEach
    void countTests(){
        counter++;
        System.out.println("@BeforeEach, number of test #" + counter);
    }

    @Nested
    @DisplayName("Adding and removing operation tests")
    class SubTests{

        @Test
        @DisplayName("AddingElementShouldIncreaseTheSizeOfListByOne")
        void testAddFigure(){
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
        @DisplayName("RemovingElementFromTheListShouldDecreaseListSizeByOne")
        void testRemoveFigure(){
            //given
            List<Shape> testShapes = new ArrayList<>();
            ShapeCollector shapeCollector = new ShapeCollector(testShapes);
            Shape shape1 = new Square("Square", 1);
            shapeCollector.addFigure(shape1);

            //when
            List<Shape> expectedList = new ArrayList<>();
            shapeCollector.removeFigure(shape1);

            //then
            assertEquals(expectedList.size(), testShapes.size());
            assertEquals(expectedList, testShapes);
        }
    }

    @Nested
    @DisplayName("Second part of tests")
    class SubTests2 {

        @Test
        @DisplayName("Get Figure")
        void testGetFigure(){
            //given
            List<Shape> testShapes = new ArrayList<>();
            ShapeCollector shapeCollector = new ShapeCollector(testShapes);
            Shape shape1 = new Square("Square", 1.0);
            Shape shape2 = new Circle("Circle", 1.0);
            shapeCollector.addFigure(shape1);
            shapeCollector.addFigure(shape2);

            //when
            String expectedShapeName = "Circle";
            String realShapeName = shapeCollector.getFigure(1).getShapeName();
            Shape expectedShape = shape1;
            Shape realShape = shapeCollector.getFigure(0);

            //then
            assertEquals(expectedShapeName, realShapeName);
            assertEquals(expectedShape, realShape);
        }

        @Test
        @DisplayName("Show Figure")
        void testShowFigure(){
            //given
            List<Shape> testShapes = new ArrayList<>();
            ShapeCollector shapeCollector = new ShapeCollector(testShapes);
            Shape shape1 = new Square("Square", 1.0);
            shapeCollector.addFigure(shape1);

            //when
            String expected = "[Square:1.0]";
            String realString = shapeCollector.showFigures();

            //then
            assertEquals(expected, realString);
        }
    }
}
