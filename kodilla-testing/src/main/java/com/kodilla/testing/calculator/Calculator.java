package com.kodilla.testing.calculator;

public class Calculator {

    private int a;
    private int b;

    public Calculator() {
    }

    public Calculator(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getA(){
        return a;
    }

    public int getB() {
        return b;
    }

    public int add(int a, int b){
        System.out.print("add(): ");
        return a + b;
    }

    public int subtract(int a, int b){
        System.out.print("subtract(): ");
        return a - b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calculator that = (Calculator) o;

        if (a != that.a) return false;
        return b == that.b;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        return result;
    }
}
