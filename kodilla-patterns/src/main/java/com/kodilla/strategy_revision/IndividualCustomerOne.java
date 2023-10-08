package com.kodilla.strategy_revision;

public final class IndividualCustomerOne extends CustomerOne{

    public IndividualCustomerOne(String name) {
        super(name);
        this.buyPredictorOne = new ConservativePredictorOne();
    }
}
