package com.kodilla.patterns.strategy_youtube;

public class CarefulStrategy implements InvestmentStrategy {
    @Override
    public void invest() {
        System.out.println("invest() from CarefulStrategy class");
    }
}
