package com.kodilla.good.patterns.challenges;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PurchaseRepository {

    void createPurchase(Buyer buyer, LocalDateTime transactionDateTime, BigDecimal price);

}
