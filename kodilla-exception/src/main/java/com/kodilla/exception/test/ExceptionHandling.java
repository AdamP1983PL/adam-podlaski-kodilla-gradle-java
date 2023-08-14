package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            String result = secondChallenge.probablyWillThrowException(2, 11.5);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Exception!!!!! " + e);
        } finally {
            System.out.println("I will always be executed");
        }

    }
}
