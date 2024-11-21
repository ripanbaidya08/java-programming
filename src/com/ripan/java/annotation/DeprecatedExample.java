package com.ripan.java.annotation;

/**
 * java use @Deprecated on few inbuilt methods.
 * we can use @Deprecated in our methods, to show that this method would no longer supported in higher version
 * @annotaion: @Deprecated
  */

public class EgDeprecated {

    @Deprecated
    public static void methodDeprecated(){
        System.out.println("this is an deprecated method, this would no longer been supported in higher version.");
    }

    public static void main(String[] args) {

        methodDeprecated();
    }
}
