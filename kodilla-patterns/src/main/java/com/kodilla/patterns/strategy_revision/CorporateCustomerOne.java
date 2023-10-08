package com.kodilla.patterns.strategy_revision;

public final class CorporateCustomerOne extends CustomerOne{

    public CorporateCustomerOne(String name) {
        super(name);
        this.buyPredictorOne = new BalancedPredictorOne();
    }
}
