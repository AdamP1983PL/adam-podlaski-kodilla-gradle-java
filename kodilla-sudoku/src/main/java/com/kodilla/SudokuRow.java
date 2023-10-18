package com.kodilla;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    public static List<Integer> rows(SudokuElement sudokuElement) {
        List<Integer> rows = new ArrayList<>();

//        for (int i = 0; i < SudokuGame.BOARD_SIZE; i++) {
//            rows.add(sudokuElement.value);
//        }

        for (int i = 0; i < SudokuGame.BOARD_SIZE; i++) {
            rows.add(i);
        }

        return rows;
    }

    public static void printSudokuRow(SudokuRow sudokuRow){
        System.out.println(sudokuRow);
    }
}
