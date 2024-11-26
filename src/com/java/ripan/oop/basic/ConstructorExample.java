package com.java.ripan.oop.basic;

/**
 * Constructor is a method, whose name is same as class.
 * return nothing. it called at the time of object creation
 * constructor can be, parameterized and non-parameterized
 */

class Employee{
    int id;
    String name;
    String role;

    // non-parameterized
    public Employee(){ }

    // parameterized
    public Employee(int id, String name, String role){
        this.id = id;
        this.name = name;
        this.role = role;
    }

    // display employee information using toString()

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
public class ConstructorExample {
    public static void main(String[] args) {

        Employee emp1 = new Employee(1, "sachin", "software developer");
        Employee emp2 = new Employee(2, "virat", "ML-Engineer");

        System.out.println(emp1.toString());

        System.out.println(emp2.toString());
    }
}
