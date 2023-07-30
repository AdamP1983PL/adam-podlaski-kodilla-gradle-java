package com.kodilla.testing;


import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUserName();
        if (result.equals("theForumUser")) {
            System.out.println("Test ok");
        } else {
            System.out.println("Error!");
        }

        System.out.println("\nTest - pierwszy test jednostkowy:");

        Calculator calculator = new Calculator();

        int sum = calculator.add(5, 10);
        System.out.println(sum);
        if (sum == 15) {
            System.out.println("Test ok");
        } else {
            System.out.println("Error!");
        }

        int subtract = calculator.subtract(5, 10);
        System.out.println(subtract);
        if (subtract == -5) {
            System.out.println("Test ok");
        } else {
            System.out.println("Error!");
        }

    }
}
