package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static com.kodilla.stream.array.ArrayOperations.getAverage;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        //given
        int[] arr = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        //when
        double average = getAverage(arr);
        double arrAverageUsingForLoop = averageUsingForLoopMethod(arr);

        //then
        assertEquals(average, arrAverageUsingForLoop);
    }

    private static double averageUsingForLoopMethod(int[] arr) {
        double averageUsingForLoop = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            averageUsingForLoop += arr[i];
            count++;
        }
        return averageUsingForLoop / count;
    }
}
