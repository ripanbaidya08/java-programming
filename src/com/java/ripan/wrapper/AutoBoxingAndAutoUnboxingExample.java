package com.java.ripan.wrapper;
/**
 * AutoBoxing: the automatic conversion of primitive data to Wrapper object by the compiler, internally compiler call valueOf() method
 * AutoUnBoxing : the automatic conversion of Wrapper object to Primitive data by the compiler, Internally compiler will call the : xyzValue() method. Eg: intValue(), floatValue() etc.
 */
public class AutoBoxingAndAutoUnboxingExample {
    public static void main(String[] args) {

        /* *
         * Integer wrapperObject1 = Integer.valueOf(primitiveData1); :: AutoBoxing
         * AutoBoxing
         */
        int primitiveData1 = 10;
        Integer wrapperObject1 = primitiveData1;
        System.out.println(primitiveData1);
        System.out.println(wrapperObject1);

        /**
         * int i4 = wrapperObject2.intValue(); :: AutoUnBoxing
         * AutoUnboxing
         */
        Integer wrapperObject2 = 10;
        int i4 = wrapperObject2;
        System.out.println(primitiveData1);
        System.out.println(wrapperObject1);

    }
}