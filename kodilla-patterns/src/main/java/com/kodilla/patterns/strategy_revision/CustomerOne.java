package com.kodilla.patterns.strategy_revision;

public sealed class CustomerOne permits CorporateCustomerOne, IndividualCustomerOne, IndividualYoungCustomerOne {

    private final String name;
    protected BuyPredictorOne buyPredictorOne;

    public CustomerOne(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String predict(){
        return buyPredictorOne.predictWhatToBuy();
    }

    public void setBuyingPredictorOne(BuyPredictorOne buyPredictorOne) {
        this.buyPredictorOne = buyPredictorOne;
    }
}
