package com.ripan.production.oop.polymorphism;

class Plane {
    String engine;
    float fuel;
    int wheel;

    public void takeOff() {
        System.out.println("Plane tookoff...");
    }

    public void fly() {
        System.out.println("Plane is flying...");
    }

    public void land() {
        System.out.println("Plane is landing...");
    }

    public void carry() {

        System.out.println("Plane is carrying...");
    }
}

class Passenger extends Plane {
    @Override public void carry() {
        System.out.println("Carrying Passengers...");
    }
}

class Cargo extends Plane {
    @Override public void carry() {
        System.out.println("Carrying Cargo...");
    }
}

class Fighter extends Plane {
    @Override public void carry() {
        System.out.println("Carrying Weapons...");
    }
}

//Helper class
class Airport {
    /*MethodOverriding :TruePolymrophsim[1:M]
    Runtime polymorphism
                = new Cargo();
    Plane ref   = new Passenger();
                = new Fighter();
    */
    public void allowPlane(Plane ref) {
        System.out.println("Object name is :: "+ref.getClass().getName());
        ref.takeOff();
        ref.carry();
        ref.fly();
        ref.land();
        System.out.println();
    }
}

public class MethodOverridingExample3 {
    public static void main(String[] args) {

        //Creating 3 objects of Plane Type
        Cargo c = new Cargo();
        Passenger p =new Passenger();
        Fighter f = new Fighter();

        //Taking the actions for all the 3 planes

        Airport a = new Airport();
        a.allowPlane(c);
        a.allowPlane(p);
        a.allowPlane(f);
    }
}
