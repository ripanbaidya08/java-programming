package com.java.ripan.wrapper;

/**
 * Wrapper Class: to wrap primitive data into object and vice versa.
 * with this we can handle primitives just like object.
 * eg: int -> Integer, char -> Character and so on.
 *
 */
public class WrapperClassExample {
    public static void main(String[] args) {

        // string -> primitive : parseXYZ()
        String s1 = "10";
        int i1 = Integer.parseInt(s1);
        System.out.println(i1);

        String s2 = "10.5";
        double d1 = Double.parseDouble(s2);
        System.out.println(d1);

        // primitive/wrapper Object -> string : toString()
        int i2 = 20; // primitive type
        String s3 = Integer.toString(i2);
        System.out.println(s3); // 20

        Double d2 = 25.5; // wrapper class
        String s4 = Double.toString(d2);
        System.out.println(s4); // 25.5

        // string/primitive -> wrapper : valueOf()
        String s5 = "30";
        Integer in = Integer.valueOf(s5);
        System.out.println(in); // 30

        float f = 3.2f;
        Float fl = Float.valueOf(f);
        System.out.println(fl); // 3.2

        // wrapper -> primitive : xyzValue()
        Integer in2 = 8;
        int num = in2.intValue();
        System.out.println(num); // 8

        Double db = 13.10;
        double d3 = db.doubleValue();
        System.out.println(d3); // 13.10

    }
}
