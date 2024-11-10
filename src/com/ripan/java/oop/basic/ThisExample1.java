package com.ripan.production.oop.basic;

class ThisExample1 {

    int id;
    String name;

    // Constructor using 'this' to refer to instance variables
    public ThisExample1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to display details using 'this' to call another method
    public void display() {
        this.showDetails();  // 'this' is used to call another method in the class
    }

    // Method to show details
    public void showDetails() {
        System.out.println("ID: " + id + ", Name: " + name);
    }

    // Method returning 'this' keyword
    public ThisExample1 getInstance() {
        return this;  // Returns the current instance of the class
    }

    public static void main(String[] args) {

        ThisExample1 example = new ThisExample1(101, "Alice");

        // Using 'this' to refer to instance variables and calling methods
        example.display();

        // Using 'this' as a return statement
        ThisExample1 sameInstance = example.getInstance();
        System.out.println("Instance obtained from getInstance: " + sameInstance);
    }
}
