package com.ripan.production.series;

// sum = 1^2 + 2^2 + 3^2 + .... n^2, where n is natural number.


public class Q5 {
    public static void main(String[] args) {

        int n = 5;
        int sum = 0;

        for(int i = 1 ; i <= n ; i ++){
            sum += 1 / (Math.pow(i, 2));
        }

        System.out.println("sum = "+sum);
    }
}
