package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawerTestSuite {

    @Test
    void testDoDrawingWithCircle(){
        // given
        Circle circle = new Circle();

        // when
        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();

        // then
        assertEquals("This is a Circle", result);
    }

    @Test
    void testDoDrawingWithTriangle(){
        // given
        Triangle triangle = new Triangle();

        // when
        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();

        // then
        assertEquals("This is a Triangle", result);
    }
}
