package com.kodilla.patterns.strategy;

public final class BalancedPredictor implements BuyPredictor {

    @Override
    public String predictWhatToBuy() {
        return "Balanced Predictor: Buy share units of Fund XYZ";
    }
}
