package com.java.ripan.series;

// sum = 1 + 1/2 + 1/4 + 1/8 + .... n

public class Q1 {
    public static void main(String[] args) {

        int n = 5;
        double sum = 0.0;

        for(int i = 0 ; i < n ; i ++){
            sum += 1 / (Math.pow(2, i));
        }

        System.out.println("sum = "+sum);
    }
}
