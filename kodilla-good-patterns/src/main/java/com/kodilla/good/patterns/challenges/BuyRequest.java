package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class BuyRequest {

    private Buyer buyer;
    private LocalDateTime timeOfPurchase;

    public BuyRequest(Buyer buyer, LocalDateTime timeOfPurchase) {
        this.buyer = buyer;
        this.timeOfPurchase = timeOfPurchase;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public LocalDateTime getTimeOfPurchase() {
        return timeOfPurchase;
    }
}
