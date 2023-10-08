package com.kodilla.patterns.strategy_youtube;

public class AggressiveStrategy1 implements InvestmentStrategy  {

    @Override
    public void invest() {
        System.out.println("invest() from AggressiveStrategy class");
    }
}
