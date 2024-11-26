package com.java.ripan.generics;

// generics with wild card Character (?)
// public static void meth(ArrayList< ? > al){ }

import java.util.ArrayList;

public class Eg3 {

    // it won't accept any value except null.
    // usually used to perform the read operation
    public static void m1(ArrayList<?> al){}


    public static void main(String[] args) {

        ArrayList<String> al = new ArrayList<>();
        m1(al);

        ArrayList<Integer> al2 = new ArrayList<>();
        m1(al2);

        ArrayList<Double> al3 = new ArrayList<>();
        m1(al3);

    }
}
