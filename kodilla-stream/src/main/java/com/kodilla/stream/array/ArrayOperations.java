package com.kodilla.stream.array;

/*Metoda getAverage(int[]numbers)powinna:
        przy pomocy strumienia IntStream oraz metody
        range(int startInclusive,int endExclusive)
        wyświetlić kolejne elementy tablicy,
        a następnie:
        przy pomocy drugiego strumienia IntStream oraz
        metody range(int startInclusive,int endExclusive),
        a także kolektora average()obliczyć średnią.
        Na końcu metoda powinna zwracać średnią jako wynik typu double.*/

import java.util.OptionalDouble;
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
