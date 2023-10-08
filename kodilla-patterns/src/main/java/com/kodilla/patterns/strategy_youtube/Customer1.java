package com.kodilla.patterns.strategy_youtube;

public class Customer1 {

    private String name;
    private InvestmentStrategy investmentStrategy;

    public Customer1() {
    }

    public Customer1(String name, InvestmentStrategy investmentStrategy) {
        this.name = name;
        this.investmentStrategy = investmentStrategy;
    }

    public void invest(){
        investmentStrategy.invest();
    }

    public String getName() {
        return name;
    }

    public InvestmentStrategy getInvestmentStrategy() {
        return investmentStrategy;
    }

    public void setInvestmentStrategy(InvestmentStrategy investmentStrategy) {
        this.investmentStrategy = investmentStrategy;
    }
}
