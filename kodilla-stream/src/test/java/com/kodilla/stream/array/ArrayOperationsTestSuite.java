package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        //given
        int[] arr = {1, 2, 3};

        //when
        double expected = 2;
        double average = ArrayOperations.getAverage(arr);

        //then
        assertEquals(expected, average);
    }
}
