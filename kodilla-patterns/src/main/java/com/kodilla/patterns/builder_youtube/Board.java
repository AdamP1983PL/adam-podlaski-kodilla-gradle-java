package com.kodilla.patterns.builder_youtube;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<BoardRow> rows = new ArrayList<>();
    private FigureColor whoseMove;

    private Board() {
        for (int i = 0; i < 8; i++) {
            rows.add(new BoardRow());
        }
    }

    public Figure getFigure(int col, int row){
        return rows.get(row).getCols().get(col);
    }

    public void setFigure(int col, int row, Figure figure){
        rows.get(row).getCols().set(col, figure);
    }

    static class Builder{
        private List<FigureOnBoard> figures = new ArrayList<>();
        private FigureColor whoseMove;

        public Builder whoseMove(FigureColor color){
             whoseMove = color;
             return this;
        }

        public Builder figure(int col, int row, FigureType figureType, FigureColor figureColor){
            figures.add(new FigureOnBoard(col, row, figureType, figureColor));
            return this;
        }

        public Board build(){
            Board board = new Board();
            board.whoseMove = whoseMove;
            for(FigureOnBoard figure: figures){
                Figure figureToPlace;
                if(figure.figureType == FigureType.PAWN){
                    figureToPlace = new Pawn(figure.color);
                } else {
                    figureToPlace = new Queen(figure.color);
                }
                board.setFigure(figure.col, figure.row, figureToPlace);
            }
            return board;
        }
    }

    static class FigureOnBoard{
        private int col;
        private int row;
        private FigureType figureType;
        private FigureColor color;

        public FigureOnBoard(int col, int row, FigureType figureType, FigureColor color) {
            this.col = col;
            this.row = row;
            this.figureType = figureType;
            this.color = color;
        }

        public int getCol() {
            return col;
        }

        public int getRow() {
            return row;
        }

        public FigureType getFigureType() {
            return figureType;
        }

        public FigureColor getColor() {
            return color;
        }
    }



    @Override
    public String toString() {
        String s = "|------------------------|\n";
        for (int row = 0; row < rows.size(); row++) {
            s += rows.get(row).toString();
        }
        s += "|------------------------|\n";
        return s;
    }
}
