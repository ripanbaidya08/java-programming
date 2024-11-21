package com.ripan.java.annotation;

import java.lang.annotation.Inherited;

// by default the annoations are not Inheritable, so inorder to make them inheritable we use @Inheritable

@Inherited
@interface Persistable{
    // lets say, the duty of this annotation is to save the object of the class to the database...
}

@Persistable
class Employees{ }

class SoftwareEngineer extends Employees{ }

public class InheritedExample {
    public static void main(String[] args) {

        // main

        // now, both Employees and SoftwareEngineer class is persistable.
    }
}

