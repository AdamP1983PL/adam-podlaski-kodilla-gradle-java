package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static com.kodilla.stream.array.ArrayOperations.getAverage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        //given
        int[] arr = {1, 2, 3};

        //when
        double average = getAverage(arr);
        double arrAverageUsingForLoop = 2;

        //then
        assertEquals(average, arrAverageUsingForLoop);
    }


    //zahardkodować wartość oczekiwanią
}
