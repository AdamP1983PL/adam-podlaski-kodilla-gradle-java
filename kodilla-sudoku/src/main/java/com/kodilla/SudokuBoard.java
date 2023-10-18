package com.kodilla;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    public static List<SudokuRow> sudokuBoard(SudokuRow sudokuRow){
        List<SudokuRow> theBoard = new ArrayList<>();

        for (int i = 0; i < SudokuGame.BOARD_SIZE; i++) {
            theBoard.add(sudokuRow);
        }
        return theBoard;
    }

    public static void printBoard(SudokuBoard sudokuBoard){
        System.out.println(sudokuBoard);
    }
}
