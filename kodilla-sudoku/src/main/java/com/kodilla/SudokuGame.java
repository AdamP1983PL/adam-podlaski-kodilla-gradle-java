package com.kodilla;

public class SudokuGame {
    public static int BOARD_SIZE = 9;

    public static void solveSudoku(){
        boolean gameFinished = false;
        while(!gameFinished){
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();
        }
    }

    public static boolean resolveSudoku(){
        return false;
    }
}
