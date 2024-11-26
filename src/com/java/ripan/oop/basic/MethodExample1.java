package com.java.ripan.oop.basic;

/**
 * need to define return type, if nothing to return then void
 * can accept parameter and not also.
 * explain using sum()
 */

class SumCalculation{

    void sumVoid(int n1, int n2){
        // does not return anything
        System.out.println(n1+n2);
    }

    int sumInt(int n1, int n2){
        // return result
        return n1 + n2;
    }

}
public class MethodExample1 {
    public static void main(String[] args) {

        int num1 = 10, num2 = 20;

        new SumCalculation().sumVoid(num1, num2);

        // since sumInt() return an integer value so that, it a variable must catch the return value
        int resultSum = new SumCalculation().sumInt(num1, num2);

        System.out.println("sum is: "+resultSum);

    }
}
