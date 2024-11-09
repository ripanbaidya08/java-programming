package com.ripan.production.oop.abstraction;

interface Calculator{

    void add(int n1, int n2);
    void sub(int n1, int n2);
    void multi(int n1, int n2);
    void div(int n1, int n2);

}

class CalculatorImpl implements Calculator{

    @Override public void add(int n1, int n2) {
        System.out.println(n1+n2);
    }

    @Override public void sub(int n1, int n2) {
        System.out.println(n1-n2);
    }

    @Override public void multi(int n1, int n2) {
        System.out.println(n1*n2);
    }

    @Override public void div(int n1, int n2) {
        System.out.println(n1/n2);
    }
}

public class InterfaceExample {
    public static void main(String[] args) {

        Calculator calc = new CalculatorImpl();

        calc.add(10, 20);
        calc.sub(20, 10);
        calc.multi(10, 5);
        calc.div(10, 5);
    }
}
