package com.githubgradlekodidemo;

public class Calculator {
    int x;
    int y;

    public Calculator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int add(int x, int y){
        return x + y;
    }

    public int subtract(int x, int y){
        return x - y;
    }
}
