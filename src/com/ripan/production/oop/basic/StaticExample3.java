package com.ripan.production.oop.basic;

public class StaticExample3 {
    static {
        methodOne();
    }

    public static void main(String[] args) {
        // main
    }

    public static void methodOne() {
        System.out.println(i);
    }

    static int i = 10;

    /**
     * out: 0
     */
}
