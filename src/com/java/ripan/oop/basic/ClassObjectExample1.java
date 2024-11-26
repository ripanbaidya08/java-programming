package com.java.ripan.oop.basic;

/**
 * a class is a blueprint. it can have properties and methods
 * properties -> data members
 * methods -> member functions
 */

class Student{
    // properties
    int id;
    String name;
    int age;

}

public class ClassObjectExample1 {
    public static void main(String[] args) {

        // create an object
        Student s1 = new Student();

        // set value of properties using object
        s1.id = 1;
        s1.name = "Ripan";
        s1.age = 20;

        // printing the values using object
        System.out.println(s1.id);
        System.out.println(s1.name);
        System.out.println(s1.age);
    }
}
