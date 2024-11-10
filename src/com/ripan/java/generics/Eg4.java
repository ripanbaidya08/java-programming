package com.ripan.java.generics;

class MyGenClass<T> {
    T obj;

    public MyGenClass(T obj){
        this.obj =obj;
    }

    public T getObj(){
        return obj;
    }

    public void process(){
        System.out.println("Processing obj....");
    }
}
public class Eg4 {
    public static void main(String[] args) {

        MyGenClass<String> c1 =new MyGenClass<>("sachin"){
            @Override public void process(){
                System.out.println("Processing :: "+getObj());
            }
        }; c1.process();

        MyGenClass<String> c2 =new MyGenClass<>("dhoni"){

            @Override public void process(){
                System.out.println("Processing :: "+getObj());
            }
        };c2.process();

    }
}
