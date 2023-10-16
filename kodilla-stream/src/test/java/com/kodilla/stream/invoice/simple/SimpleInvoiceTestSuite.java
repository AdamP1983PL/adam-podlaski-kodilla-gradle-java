package com.kodilla.stream.invoice.simple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleInvoiceTestSuite {

    @Test
    void testGetValueToPay(){
        //given
        SimpleInvoice invoice = new SimpleInvoice();

        //when
        invoice.addItem(new SimpleItem(new SimpleProduct("Produce 1", 17.28 ), 2.0));
//        invoice.getItems().get(1).product.getProductName().equals("Produce 2")
        invoice.addItem(new SimpleItem(new SimpleProduct("Produce 2", 11.99 ), 3.5));
        invoice.addItem(new SimpleItem(new SimpleProduct("Produce 3", 6.49 ), 5.0));

        System.out.println(invoice.getItems().size());

        //then
        assertEquals(108.975, invoice.getValueToPay(), 0.001);

    }

}
