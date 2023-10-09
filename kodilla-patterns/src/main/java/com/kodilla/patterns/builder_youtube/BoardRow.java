package com.kodilla.patterns.builder_youtube;

import java.util.ArrayList;
import java.util.List;

public class BoardRow {
    private List<Figure> cols = new ArrayList<>();

    public BoardRow() {
        for (int i = 0; i < 8; i++) {
            cols.add(new None());
        }
    }

    public List<Figure> getCols() {
        return cols;
    }

    @Override
    public String toString() {
        String s = "|";
        for (int col = 0; col < cols.size(); col++) {
            s += cols.get(col).toString() + "|";
        }
        s += "\n";
        return s;
    }
}
