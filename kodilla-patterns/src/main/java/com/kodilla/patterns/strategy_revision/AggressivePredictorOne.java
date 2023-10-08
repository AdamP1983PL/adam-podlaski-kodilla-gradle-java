package com.kodilla.patterns.strategy_revision;

public final class AggressivePredictorOne implements BuyPredictorOne {
    @Override
    public String predictWhatToBuy() {
        return "predictWhatToBuy() from AggressivePredictorOne";
    }
}
