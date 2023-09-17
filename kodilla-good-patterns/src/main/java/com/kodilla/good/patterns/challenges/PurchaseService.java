package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public interface PurchaseService {

    public boolean buy(final Buyer buyer, final LocalDateTime purchaseDateTime, final Product product);

}
