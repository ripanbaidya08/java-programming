package com.java.ripan.annotation;

/**
 * The @SuppressWarnings annotation in Java is used to instruct the compiler to ignore specific warnings for a particular section of code.
 * This is often helpful when you have a piece of code that might generate a compiler warning but is safe or intended as-is.
 * It helps keep the codebase clean of warnings that you have reviewed and intentionally chosen to ignore
 * @annotaion: @SuppressWarnings
 */


import java.util.ArrayList;
import java.util.List;

public class SuppressWarningExample {

    @SuppressWarnings("unchecked") // Suppresses the unchecked warning
    public static void main(String[] args) {
        List rawList = new ArrayList(); // raw type usage
        rawList.add("example");

        @SuppressWarnings("deprecation") // Suppresses the deprecation warning
        DeprecatedClass obj = new DeprecatedClass();
        obj.deprecatedMethod();
    }
}

class DeprecatedClass {
    @Deprecated
    public void deprecatedMethod() {
        System.out.println("This is a deprecated method.");
    }
}

