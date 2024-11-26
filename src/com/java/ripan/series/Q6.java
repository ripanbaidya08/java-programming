package com.java.ripan.series;

// sum = 1 + 1/2! + 1/3! + 1/4! + .... 1/n! where n is natural number.

public class Q6 {
    static int factorial(int n) {

        int fact = 1;
        for(int i = 1; i <= n; i ++){
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {

        int n = 5;
        int sum = 0;

        for(int i = 1 ; i <= n ; i ++){
            sum += 1/factorial(i);
        }

        System.out.println("sum = "+sum);
    }
}
