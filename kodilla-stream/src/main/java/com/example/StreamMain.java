package com.example;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("Lambda, example text");
        processor.execute(codeToExecute);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Lambda: ");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Method reference:");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String textToBeautify = "Ala ma kota";
        poemBeautifier.beautify(textToBeautify, String::toUpperCase);
        poemBeautifier.beautify(textToBeautify, String::toLowerCase);
        poemBeautifier.beautify(textToBeautify, s -> "xxx_" + s + "_xxx");
        poemBeautifier.beautify(textToBeautify, s -> s.replaceAll("Ala", "Romek"));


    }
}
