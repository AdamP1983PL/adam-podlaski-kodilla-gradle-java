package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    public void before(){
        System.out.println("\nCollection Test Suite: start");
    }

    @AfterEach
    public void after(){
        System.out.println("Collection Test Suite: end\n");
    }

    @DisplayName("Checking if the class behaves correctly " +
            "when the list is empty")
    @Test
    void testOddNumbersExterminatorEmptyList(){
        //given
        OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();
        List<Integer> emptyList = new ArrayList<>();

        //when
        List<Integer> exterminatedList = oddNumberExterminator.exterminate(emptyList);
        List<Integer> expectedList = new ArrayList<>();
        System.out.println("Testing: " + expectedList + " equalsTo " + exterminatedList);

        //then
        Assertions.assertEquals(expectedList, exterminatedList);
    }

    @DisplayName("Checking if the class behaves correctly " +
            "when the list contains even and odd numbers ")
    @Test
    void testOddNumbersExterminatorNormaList(){
        //given
        OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        //when
        List<Integer> exterminatedList = oddNumberExterminator.exterminate(numbers);
        List<Integer> expectedList = new ArrayList<>(List.of(2, 4, 6));
        System.out.println("Testing: " + expectedList + " equalsTo " + exterminatedList);

        //then
        Assertions.assertEquals(expectedList, exterminatedList);
    }
}
