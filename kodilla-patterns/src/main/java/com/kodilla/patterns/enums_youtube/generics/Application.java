package com.kodilla.patterns.enums_youtube.generics;

public class Application {
    public static void main(String[] args) {

        String s = "Test message";
        int n = 10;
        Displayer<Integer> displayer = new Displayer<>();
        displayer.display(n);

        Displayer<String> displayer1 = new Displayer<>();
        displayer1.display(s);

    }
}
