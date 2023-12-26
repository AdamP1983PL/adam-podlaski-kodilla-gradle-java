package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) {

        try {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            System.out.println(a / b);
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        return a / b;
    }


    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        firstChallenge.divide(1, 0);

    }

}
