package com.kodilla;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class SudokuRow {
    private List<SudokuElement> sudokuElements = new ArrayList<>();

    public SudokuRow() {
        for (int i = 0; i < SudokuGame.BOARD_SIZE; i++) {
            sudokuElements.add(new SudokuElement());
        }
    }

    @Override
    public String toString() {
        String rowString = "|";
        for (int i = 0; i < SudokuGame.BOARD_SIZE; i++) {
            if ((i + 1) % 3 == 0) {
                rowString += sudokuElements.get(i).toString() + " | ";
            } else {
                rowString += sudokuElements.get(i).toString() + "  ";
            }
        }
        return rowString;
    }
}
