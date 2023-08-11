package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();

    public ShapeCollector() {
    }

    public ShapeCollector(List<Shape> shapes) {
        this.shapes = new ArrayList<>(shapes);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public void removeFigure(Shape shape){
        shapes.remove(shape);
    }

    public Shape getFigure(int n){
        return shapes.get(n);
    }

    public String showFigures(){
        String temp = "";
        for(Shape shape : shapes){
            temp +=shape.getShapeName() + "->" + shape.getField() + ",";
        }
        System.out.println("Real String toLowerCase(): " + temp.toLowerCase());
        return temp.toLowerCase();
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
