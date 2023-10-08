package com.kodilla.strategy_revision;

public sealed interface BuyPredictorOne permits AggressivePredictorOne, BalancedPredictorOne, ConservativePredictorOne {

    String predictWhatToBuy();
}
