package com.kodilla.patterns.strategy_revision;

public final class IndividualYoungCustomerOne extends CustomerOne{

    public IndividualYoungCustomerOne(String name) {
        super(name);
        this.buyPredictorOne = new AggressivePredictorOne();
    }
}
