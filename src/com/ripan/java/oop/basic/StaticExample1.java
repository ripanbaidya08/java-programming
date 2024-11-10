package com.ripan.production.oop.basic;

public class StaticExample1 {
    static {
        System.out.println("First static block");
    }
    static {
        System.out.println("Second static block");
    }
    public static void main(String[] args) {

    }
    /**
     * out:
     * First static block
     * Second static block
     */
}
