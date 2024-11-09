package com.ripan.production.oop.inheritence;

class Parent1 {

    //Constructor
    Parent1() {
        System.out.println("Parent class constructor");
    }
}

class Child1 extends Parent {

    //Constructor
    Child1() {
        System.out.println("Child class constructor");
    }
}

public class ConstrctorCreationBasedOnRelationshipOfObject {
    public static void main(String[] args) {
        Parent p = new Parent();
        System.out.println();
        Child c= new Child();
    }

    /**
     * Parent class constructor
     * Parent class constructor
     * Child class constructor
     */
}
