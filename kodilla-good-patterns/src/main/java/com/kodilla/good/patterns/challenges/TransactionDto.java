package com.kodilla.good.patterns.challenges;

public class TransactionDto {

    private Buyer buyer;
    private boolean sold;

    public TransactionDto(Buyer buyer, boolean sold) {
        this.buyer = buyer;
        this.sold = sold;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public boolean isSold() {
        return sold;
    }
}
