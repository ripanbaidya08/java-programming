package com.ripan.production.generics;

// In generics a type parameter is associated to the class.
// T -> type parameter

class Gen<T>{
    T t;

    public Gen(T t){
        this.t = t;
    }

    void show(){
        System.out.println("type of class: "+t.getClass().getName());
    }

    T getT(){
        return t;
    }
}

public class Eg1 {
    public static void main(String[] args) {

        Gen<String> str = new Gen<>("jon");
        str.show();
        System.out.println(str.getT());

        Gen<Integer> in = new Gen<>(10);
        in.show();
        System.out.println(in.getT());

        Gen<Double> db = new Gen<>(10.00);
        db.show();
        System.out.println(db.getT());

    }
}
