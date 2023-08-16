package com.kodilla.testing.collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Collection test suite")
public class CollectionTestSuite {

    @BeforeAll
    static void beforeAll(){
        System.out.println("@BeforeAll");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("@AfterAll");
    }
    @DisplayName("Checking if the class behaves correctly " +
            "when the list is empty")
    @Test
    void testOddNumbersExterminatorEmptyList(){

        //given
        List<Integer> numbers = new ArrayList<>();
        OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();

        //when
        List<Integer> exterminatedNumbers =  oddNumberExterminator.exterminate(numbers);
        List<Integer> expectedList = new ArrayList<>();
        System.out.println("Inside testing class");

        //then
        assertEquals(expectedList, exterminatedNumbers);
        assertEquals(expectedList.size(), exterminatedNumbers.size());
        assertEquals(0, exterminatedNumbers.size());
    }

    @DisplayName("Checking if the class behaves correctly " +
            "when the list contains even and odd numbers ")
    @Test
    void testOddNumbersExterminatorNormalList(){

        //given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        OddNumberExterminator oddNumberExterminator = new OddNumberExterminator();


        //when
        List<Integer> oddNumbers = oddNumberExterminator.exterminate(numbers);
        System.out.println(numbers);
        List<Integer> expectedNumbers = new ArrayList<>(List.of(2, 4, 6));

        //then
        assertEquals(expectedNumbers.size(), oddNumbers.size());
        assertEquals(2, oddNumbers.get(0));
    }
}
