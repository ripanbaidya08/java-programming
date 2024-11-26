package com.java.ripan.oop.basic;

class Book{
    // properties
    int id;
    String name;
    double price ;

}

public class ClassObjectExample2 {
    public static void main(String[] args) {

        Book b1 = new Book();

        b1.id = 1;
        b1.name = "Mastering Spring Boot Microservice";
        b1.price = 1000.0;

        System.out.println("id: "+b1.id);
        System.out.println("name: "+b1.name);
        System.out.println("price: "+b1.price);
    }
}
