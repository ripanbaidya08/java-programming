package com.java.ripan.oop.basic;

public class StaticExample2 {
    static int i = 10;

    static {
        methodOne();
        System.out.println("First static block");
    }

    public static void main(String[] args) {
        methodOne();
        System.out.println("Inside main method");
    }

    public static void methodOne() {
        System.out.println(j);
    }

    static {
        System.out.println("Second static block");
    }
    static int j = 20;

    /**
     * out:
     * 0
     * First static block
     * Second static block
     * 20
     * Inside main method
     */
}
