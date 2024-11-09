package com.ripan.production.oop.inheritence;

class Parent {

    public void methodOne() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {
    //inherited method(public category from parent)
    public void methodOne() {
        System.out.println("Parent method");
    }

    //Specialized method
    public void methodTwo() {
        System.out.println("Child method");
    }
}

class ParentChildRelationship {
    public static void main(String[] args) {

        Parent p= new Parent();
        p.methodOne();
//        p.methodTwo(); //CE: can't find symbol

        System.out.println();

        Child c = new Child();
        c.methodOne();
        c.methodTwo();

        System.out.println();

        Parent p1 =new Child();
        p1.methodOne();
//        p1.methodTwo();//CE: can't find symbol

        System.out.println();

//        Child c1 = new Parent();//incompatible types
    }
}