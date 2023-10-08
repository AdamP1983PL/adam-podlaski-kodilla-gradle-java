package com.kodilla.patterns.strategy_youtube;

public class Application {
    public static void main(String[] args) {

        Customer1 c1 = new Customer1("John Novak", new AggressiveStrategy1());
        Customer1 c2 = new Customer1("John Smith", new CarefulStrategy());

        InvestmentEngine investmentEngine = new InvestmentEngine();
        investmentEngine.invest(c1);
        investmentEngine.invest(c2);

        c1.setInvestmentStrategy(new CarefulStrategy());
        investmentEngine.invest(c1);

    }
}
