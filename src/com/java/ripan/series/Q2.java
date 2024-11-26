package com.java.ripan.series;

// sum = 1 + 1/3+ 1/9 + 1/27 + .... n

public class Q2 {
    public static void main(String[] args) {

        int n = 5;
        double sum = 0.0;

        for(int i = 0 ; i < n ; i ++){
            sum += 1 / Math.pow(3, i);
        }

        System.out.println("sum = "+sum);
    }
}
