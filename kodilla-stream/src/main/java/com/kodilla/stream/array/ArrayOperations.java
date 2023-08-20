package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        IntStream.range(0, numbers.length).forEach(s -> System.out.println("Number: " + numbers[s]));

        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average()
                .orElse(0.0);
    }
}
