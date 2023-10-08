package com.kodilla.patterns.strategy_revision;

public sealed interface BuyPredictorOne permits AggressivePredictorOne, BalancedPredictorOne, ConservativePredictorOne {

    String predictWhatToBuy();
}
