package com.java.ripan.pattern;

public class ReverseRightHalfPyramidPattern {

    public static void reverseRightHalfPyramidPattern(int n) {
        int i, j;

        for (i = n; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        int n = 6;
        reverseRightHalfPyramidPattern(n);
    }
}
