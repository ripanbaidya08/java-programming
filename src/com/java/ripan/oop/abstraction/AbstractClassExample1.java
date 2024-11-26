package com.java.ripan.oop.abstraction;

import java.util.Scanner;

abstract class Shapee
{
    public float area;

    //abstract methods
    public abstract void input();
    public abstract void calcArea();

    //concrete methods
    public void disp(){
        System.out.println("Area is :: "+area);
    }
}

class Square extends Shapee {

    private float length;

    @Override public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length for Square object:: ");
        length = scanner.nextFloat();
    }

    @Override public void calcArea() {
        area=length*length;
    }
}

class Rectangle extends Shapee {

    private float length;
    private float breadth;

    @Override public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of Rectangleee object:: ");
        length = scanner.nextFloat();
        System.out.print("Enter the breadth of Rectanglee object:: ");
        breadth = scanner.nextFloat();
    }

    @Override public void calcArea() {
        area=length*breadth;
    }
}

class Circle extends Shapee {

    private float radius;

    @Override public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of circlee:: ");
        radius = scanner.nextFloat();
    }

    @Override public void calcArea() {
        area=3.1414f * radius *radius;
    }
}

public class AbstractClassExample1 {
    public static void main(String[] args) {
        //Creating a reference variable for Shape
        Shapee s;

        //Working with Square Object
        s = new Square();
        s.input();
        s.calcArea();
        s.disp();//generic method
        System.out.println();

        //Working with Rectangle Object
        s = new Rectangle();
        s.input();
        s.calcArea();
        s.disp();//generic method
        System.out.println();

        //Working with Circle Object
        s = new Circle();
        s.input();
        s.calcArea();
        s.disp();//generic method
    }
}