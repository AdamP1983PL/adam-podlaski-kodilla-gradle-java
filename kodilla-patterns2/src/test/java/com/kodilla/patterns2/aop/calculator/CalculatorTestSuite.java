package com.kodilla.patterns2.aop.calculator;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Calculator.class)
class CalculatorTestSuite {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorTestSuite.class);

    @Autowired
    private Calculator calculator;

    @Test
    void testAdd() {
        // given
        // when
        double result = calculator.add(10, 15);
        // then
        LOGGER.info("Testing add method");
        assertEquals(25, result);
    }

    @Test
    void testSub() {
        // given
        // when
        double result = calculator.sub(10, 15);
        // then
        LOGGER.info("Testing sub method");
        assertEquals(-5.0, result);
    }

    @Test
    void testMul() {
        // given
        // when
        double result = calculator.mul(10, 15);
        // then
        LOGGER.info("Testing div method");
        assertEquals(150, result);
    }

    @Test
    void testDiv() {
        // given
        // when
        double result = calculator.div(150, 15);
        // then
        LOGGER.info("Testing div method");
        assertEquals(10, result);
    }

    @Test
    public void testFactorial() {
        //Given
        //When
        BigDecimal result = calculator.factorial(new BigDecimal(1000));
        //Then
        LOGGER.info("Testing factorial method");
//        System.out.println(result);
        assertTrue(BigDecimal.ONE.compareTo(result) < 0);
    }


}






















