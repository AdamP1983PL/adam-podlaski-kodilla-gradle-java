package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaGetCost() {
        // given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // when
        BigDecimal cost = theOrder.getCost();
        // then
        assertEquals(new BigDecimal(15), cost);
    }

    @Test
    public void testBasicPizzaGetDescription() {
        // given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // when
        String description = theOrder.getDescription();
        // then
        assertEquals("Basic pizza", description);
    }

    @Test
    public void testBasicPizzaWithDoubleCheeseAndHamGetCost() {
        // given
        PizzaOrder theOrder = new HamDecorator(new CheeseDecorator(new CheeseDecorator(new BasicPizzaOrder())));
        // when
        BigDecimal cost = theOrder.getCost();
        // then
        assertEquals(new BigDecimal(21), cost);
    }

    @Test
    public void testBasicPizzaWithDoubleCheeseAndHamGetDescription() {
        // given
        PizzaOrder theOrder = new HamDecorator(new CheeseDecorator(new CheeseDecorator(new BasicPizzaOrder())));
        // when
        String description = theOrder.getDescription();
        // then
        assertEquals("Basic pizza + cheese + cheese + ham", description);
    }

    @Test
    void testBasicPizzaWithDoubleCheeseAndDoubleBaconGetCost() {
        // given
        PizzaOrder theOrder = new BaconDecorator(new BaconDecorator
                (new CheeseDecorator(new CheeseDecorator(new BasicPizzaOrder()))));
        // when
        BigDecimal cost = theOrder.getCost();
        // then
        assertEquals(new BigDecimal(23), cost);
    }

    @Test
    void testBasicPizzaWithDoubleCheeseAndDoubleBaconGetDescription() {
        // given
        PizzaOrder theOrder = new BaconDecorator(new BaconDecorator
                (new CheeseDecorator(new CheeseDecorator(new BasicPizzaOrder()))));
        // when
        String description = theOrder.getDescription();
        System.out.println(description);
        // then
        assertEquals("Basic pizza + cheese + cheese + bacon + bacon", description);
    }

    @Test
    void testFullOptionPizzaGetCost() {
        // given
        PizzaOrder theOrder = new TomatoDecorator(new HamDecorator
                (new CheeseDecorator(new BaconDecorator(new BasicPizzaOrder()))));
        // when
        BigDecimal cost = theOrder.getCost();
        // then
        assertEquals(new BigDecimal(23), cost);
    }

    @Test
    void testFullOptionPizzaGetDescription() {
        // given
        PizzaOrder theOrder = new TomatoDecorator(new HamDecorator
                (new CheeseDecorator(new BaconDecorator(new BasicPizzaOrder()))));
        // when
        String description = theOrder.getDescription();
        // then
        assertEquals("Basic pizza + bacon + cheese + ham + tomatoes", description);
    }
}
