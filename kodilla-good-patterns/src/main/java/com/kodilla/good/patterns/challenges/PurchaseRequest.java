package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class PurchaseRequest {

    private Buyer buyer;
    private LocalDateTime transactionDateTime;
    private Product product;

    public PurchaseRequest(Buyer buyer, LocalDateTime transactionDateTime, Product product) {
        this.buyer = buyer;
        this.transactionDateTime = transactionDateTime;
        this.product = product;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public Product getProduct() {
        return product;
    }
}
