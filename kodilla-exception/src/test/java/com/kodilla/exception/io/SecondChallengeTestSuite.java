package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SecondChallengeTestSuite {

    private SecondChallenge secondChallenge;

    @BeforeEach
    void prepareData(){
        secondChallenge = new SecondChallenge();
    }

    @Test
    void testProbablyWillThrowExceptionAllConditionDontMet(){
        //given
        //prepareData();

        //when, then
        assertDoesNotThrow(() -> {
            String result = secondChallenge.probablyWillThrowException(1.5, 2.0);
            System.out.println("Result: " + result);
            assertEquals("Done!", result);
        });
    }

    @Test
    void testProbablyWillThrowExceptionAllConditionMet(){
        //given
        //prepareData();

        //when, then
        assertThrows(Exception.class, () -> {
            secondChallenge.probablyWillThrowException(2.0, 1.5);
        });
    }

    @Test
    void testProbablyWillThrowExceptionOnlyXConditionMet(){
        //given
        //prepareData();

        //when, then
        assertThrows(Exception.class, () -> {
            secondChallenge.probablyWillThrowException(2, 112.0);
        });
    }


}
