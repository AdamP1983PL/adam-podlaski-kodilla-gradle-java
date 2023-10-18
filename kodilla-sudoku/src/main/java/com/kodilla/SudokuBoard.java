package com.kodilla;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class SudokuBoard {
    private List<SudokuRow> sudokuRows = new ArrayList<>();

    public SudokuBoard() {
        for (int i = 0; i < SudokuGame.BOARD_SIZE; i++) {
            sudokuRows.add(new SudokuRow());
        }
    }


    @Override
    public String toString() {
        String boardString = "-".repeat(39) + "\n";

        for (int i = 0; i < SudokuGame.BOARD_SIZE; i++) {
            if ((i + 1) % 3 == 0) {
                boardString += sudokuRows.get(i).toString() + "\n";
                boardString += "-".repeat(39) + "\n";
            } else {
                boardString += sudokuRows.get(i).toString() + "\n";

            }
        }
        return boardString;
    }
}
