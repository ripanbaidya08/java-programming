package com.ripan.java.annotation;

/**
 * we use @Override to override methods define in parent class and also in interface.
 * @annotaion: @Override
  */

class Parent{
    void info(){
        System.out.println("inside parent class..");
    }
}

class Child extends Parent{
    // overriding the info() method of parent class.
    @Override
    void info(){
        System.out.println("inside child class, and method is overridden..");
    }
}
public class EgOverride{

    public static void main(String[] args) {

    }

}
