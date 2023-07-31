package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes;

    public ShapeCollector(List<Shape> shapes) {
        this.shapes = new ArrayList<>(shapes);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void addFigure(Shape shape){
    }

    public void removeFigure(Shape shape){
    }

    public Shape getFigure(int n){
        return null;
    }

    public int showFigures(){
        return -1;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShapeCollector that = (ShapeCollector) o;

        return shapes.equals(that.shapes);
    }

    @Override
    public int hashCode() {
        return shapes.hashCode();
    }
}
