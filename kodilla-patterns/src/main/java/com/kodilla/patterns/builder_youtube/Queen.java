package com.kodilla.patterns.builder_youtube;

public class Queen implements Figure {

    private FigureColor color;

    public Queen(FigureColor color) {
        this.color = color;
    }

    @Override
    public FigureColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getColorCode() + "Q";
    }

    private String getColorCode() {
        if (color == FigureColor.WHITE){
            return "w";
        } else {
            return "b";
        }
    }
}
