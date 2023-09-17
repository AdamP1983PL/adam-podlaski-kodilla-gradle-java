package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class PurchaseServiceImpl implements PurchaseService {

    @Override
    public boolean buy(Buyer buyer, LocalDateTime transactionDateTime, Product product) {
        System.out.println("Buyer id: " + buyer.getId()
                + ", transaction date-time:  " + transactionDateTime.toString()
                + "Product: " + product.getName());

        return true;
    }
}
