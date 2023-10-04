package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    @Test
    void testGetLastLogMethod(){
        // given
        Logger logger = Logger.INSTANCE;
        logger.log("Test");

        // when
        String expected = "Test";
        String actual = logger.getLastLog();

        // then
        assertEquals(expected, actual);

    }

    @Test
    void shouldReturnSingletonObject(){
        // given
        Logger logger1 = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;

        // when
        long hashCodeLogger1 = logger1.hashCode();
        System.out.println(hashCodeLogger1);
        long hashCodeLogger2 = logger2.hashCode();
        System.out.println(hashCodeLogger2);

        // then
        assertEquals(logger1, logger2);
        assertEquals(hashCodeLogger1, hashCodeLogger2);
    }
}
