package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaxiOrderTestSuite {

    @Test
    public void testBasicTaxiOrderGetCost() {
        // given
        TaxiOrder theOrder = new BasicTaxiOrder();
        // when
        BigDecimal calculateCost = theOrder.getCost();
        // then
        assertEquals(new BigDecimal(5), calculateCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        // given
        TaxiOrder theOrder = new BasicTaxiOrder();
        // when
        String description = theOrder.getDescription();
        // then
        assertEquals("Drive a basic course", description);
    }

    @Test
    public void testTaxiNetworkGetCost() {
        // given
//        ====>>>> TaxiOrder theOrder = new BasicTaxiOrder();
//        ====>>>> theOrder = new TaxiNetworkOrderDecorator(theOrder);
        TaxiOrder theOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        // when
        BigDecimal calculateCost = theOrder.getCost();
        // then
        assertEquals(new BigDecimal(40), calculateCost);
    }

    @Test
    public void testTaxiNetworkGetDescription() {
        // given
//        ====>>>> TaxiOrder theOrder = new BasicTaxiOrder();
//        ====>>>> theOrder = new TaxiNetworkOrderDecorator(theOrder);
        TaxiOrder theOrder = new TaxiNetworkOrderDecorator(new BasicTaxiOrder());
        // when
        String description = theOrder.getDescription();
        // then
        assertEquals("Drive a basic course by Taxi Network", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        // given
//        ====>>>> TaxiOrder theOrder = new BasicTaxiOrder();
//        ====>>>> theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
//        ====>>>> theOrder = new ChildSeatDecorator(theOrder);
        TaxiOrder theOrder = new MyTaxiNetworkOrderDecorator(new ChildSeatDecorator(new BasicTaxiOrder()));
        // when
        BigDecimal calculateCost = theOrder.getCost();
        // then
        assertEquals(new BigDecimal(37), calculateCost);
    }


    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        // given
//        ====>>>> TaxiOrder theOrder = new BasicTaxiOrder();
//        ====>>>> theOrder = new MyTaxiNetworkOrderDecorator(theOrder);
//        ====>>>> theOrder = new ChildSeatDecorator(theOrder);
        TaxiOrder theOrder = new ChildSeatDecorator(new MyTaxiNetworkOrderDecorator(new BasicTaxiOrder()));
        // when
        String description = theOrder.getDescription();
        // then
        assertEquals("Drive a basic course by MyTaxi Network + child seat", description);
    }

    @Test
    public void testUberWithTwoChildSeatsGetCost() {
        // given
//        TaxiOrder theOrder = new BasicTaxiOrder();
//        theOrder = new UberNetworkOrderDecorator(theOrder);
//        theOrder = new ChildSeatDecorator(theOrder);
//        theOrder = new ChildSeatDecorator(theOrder);
        TaxiOrder theOrder = new ChildSeatDecorator(new ChildSeatDecorator(new UberNetworkOrderDecorator(new BasicTaxiOrder())));
        // when
        BigDecimal calculateCost = theOrder.getCost();
        // then
        assertEquals(new BigDecimal(29), calculateCost);
    }


    @Test
    public void testUberWithTwoChildSeatsGetDescription() {
        // given
//        TaxiOrder theOrder = new BasicTaxiOrder();
//        theOrder = new UberNetworkOrderDecorator(theOrder);
//        theOrder = new ChildSeatDecorator(theOrder);
//        theOrder = new ChildSeatDecorator(theOrder);
        TaxiOrder theOrder = new ChildSeatDecorator(new ChildSeatDecorator(new UberNetworkOrderDecorator(new BasicTaxiOrder())));
        // when
        String description = theOrder.getDescription();
        // then
        assertEquals("Drive a basic course by Uber Network + child seat + child seat", description);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        // given
//        TaxiOrder theOrder = new BasicTaxiOrder();
//        theOrder = new TaxiNetworkOrderDecorator(theOrder);
//        theOrder = new ExpressDecorator(theOrder);
//        theOrder = new VipCarDecorator(theOrder);
//        theOrder = new ChildSeatDecorator(theOrder);
        TaxiOrder theOrder = new ChildSeatDecorator(new VipCarDecorator(new ExpressDecorator(
                new TaxiNetworkOrderDecorator(new BasicTaxiOrder()))));
        // when
        BigDecimal calculateCost = theOrder.getCost();
        // then
        assertEquals(new BigDecimal(57), calculateCost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        // given
//        TaxiOrder theOrder = new BasicTaxiOrder();
//        theOrder = new TaxiNetworkOrderDecorator(theOrder);
//        theOrder = new ExpressDecorator(theOrder);
//        theOrder = new VipCarDecorator(theOrder);
//        theOrder = new ChildSeatDecorator(theOrder);
        TaxiOrder theOrder = new ChildSeatDecorator(new VipCarDecorator(new ExpressDecorator(
                new TaxiNetworkOrderDecorator(new BasicTaxiOrder()))));
        // when
        String description = theOrder.getDescription();
        System.out.println(description);
        // then
        assertEquals("Drive a basic course by Taxi " +
                "Network express service variant VIP + child seat", description);
    }

}
