package com.kodilla.good.patterns.challenges;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatterBuilder;

public class PurchaseRequestRetriever {

    public PurchaseRequest retrieve(){
        Buyer buyer = new Buyer("First_name_1", "Last_name_1", "email@eimal.com", 2);
        LocalDateTime transactionDateTime = LocalDateTime.of(2023, 9, 17, 17, 56, 45);
        Product product = new Product(2, "Product_2", new BigDecimal(5000));

        return new PurchaseRequest(buyer, transactionDateTime, product);
    }
}
