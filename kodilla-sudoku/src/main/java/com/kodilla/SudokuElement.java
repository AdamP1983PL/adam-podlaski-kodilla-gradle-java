package com.kodilla;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
public class SudokuElement {
    private Integer value;
    private List<Integer> values = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
    public static int EMPTY = -1;

    @Override
    public String toString() {
        if (value == null) {
            return "-1";
        }
        return Integer.toString(value);
    }

    public Integer getValue() {
        return value;
    }

    public List<Integer> getValues() {
        return values;
    }
}
