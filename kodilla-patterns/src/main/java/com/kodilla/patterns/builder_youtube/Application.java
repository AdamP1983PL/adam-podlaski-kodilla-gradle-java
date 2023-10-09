package com.kodilla.patterns.builder_youtube;

public class Application {
    public static void main(String[] args) {

        Board board = new Board.Builder()
                .whoseMove(FigureColor.WHITE)
                .figure(2, 2, FigureType.PAWN, FigureColor.BLACK)
                .figure(1, 1, FigureType.PAWN, FigureColor.BLACK)
                .figure(2, 4, FigureType.PAWN, FigureColor.BLACK)
                .figure(5, 4, FigureType.QUEEN, FigureColor.BLACK)
                .build();

//        board.setFigure(2, 2, new Pawn(FigureColor.BLACK));
//        board.setFigure(1, 1, new Pawn(FigureColor.WHITE));
//        board.setFigure(2, 4, new Pawn(FigureColor.BLACK));
//        board.setFigure(5, 4, new Queen(FigureColor.BLACK));
        System.out.println(board);
    }
}
