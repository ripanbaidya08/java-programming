package com.ripan.production.series;

// sum = 1! + 2! + 3! + .... n! where n is natural number.

public class Q4 {
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
            sum += factorial(i);
        }

        System.out.println("sum = "+sum);
    }
}
