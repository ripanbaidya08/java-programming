package com.java.ripan.oop.inheritence;
// constructor overloading example

class Demo {
    Demo(int i) {
        this(10.5f);
        System.out.println("int arg constructor");
    }

    Demo(float f) {
        System.out.println("float arg constructor");
    }

    Demo() {
        this(10);
        System.out.println("zero arg constructor");
    }

}
public class ConstructorOverloadingExample1 {
    public static void main(String[] args) {
        Demo d1= new Demo();//float-arg/int-arg/zero-arg constructor

        System.out.println();

        Demo d2= new Demo(10);//float-arg/int-arg constructor

        System.out.println();

        Demo d3= new Demo(10.5f);//float-arg constructor
    }
}
