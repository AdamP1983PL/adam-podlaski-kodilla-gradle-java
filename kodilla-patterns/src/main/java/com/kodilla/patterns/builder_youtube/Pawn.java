package com.kodilla.patterns.builder_youtube;

public class Pawn implements Figure {

    private FigureColor color;

    public Pawn(FigureColor color) {
        this.color = color;
    }

    @Override
    public FigureColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getColorCode() + "P";
    }

    private String getColorCode() {
        if (color == FigureColor.WHITE){
            return "w";
        } else {
            return "b";
        }
    }
}
