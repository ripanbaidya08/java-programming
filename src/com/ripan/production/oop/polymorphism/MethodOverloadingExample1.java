package com.ripan.production.oop.polymorphism;

class Calculation{

    void sum(int n1, int n2){
        System.out.println(n1+n2);
    }
    void sum(int n1, int n2, int n3){
        System.out.println(n1+n2+n3);
    }

    void sum(double n1, double n2){
        System.out.println(n1+n2);
    }
}

public class MethodOverloadingExample1 {
    public static void main(String[] args) {

        new Calculation().sum(10, 30);

        new Calculation().sum(93.4, 39.9);
    }
}
