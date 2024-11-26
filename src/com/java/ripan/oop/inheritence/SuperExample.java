package com.java.ripan.oop.inheritence;

class Person {
    String name;
    int age;
    String gender;
    float height;

    //Parameterized constructor :: shadowing
    Person(String name,int age,String gender,float height) {
        System.out.println("Person class constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
    }

    public void dispDetails() {
        System.out.println("Name is :: "+name);
        System.out.println("Height is :: "+height);
        System.out.println("Age is :: "+age);
        System.out.println("Gender is :: "+gender);
    }

}
class Student extends Person {
    String sid;
    int marks;

    //Parameterized constructor :shadowing
    Student(String name,int age, String gender, float height, String sid,int marks) {

        //call to parent class parameterized constructor
        super(name,age,gender,height);
        System.out.println("Student class constructor");
        this.sid = sid;
        this.marks = marks;
    }

    public void dispDetails() {
        //To call parent class dispDetails() we used super keyword.
        super.dispDetails();
        System.out.println("SID :: "+sid);
        System.out.println("MARKS :: "+marks);
    }

}

public class SuperExample {
    public static void main(String[] args) {
        Student std = new Student("sachin",49,"M",5.4f,"IND10",35);
        std.dispDetails();
    }
}
