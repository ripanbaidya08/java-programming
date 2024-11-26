package com.java.ripan.generics;

/**
 * Bounded types: we can bound the type parameter for a particular range by using extend keywords, such types are called bounded types
 * class Test<T extends Number> { }
 * @param <T>
 */

class Test1<T extends Number>{
    // since,Number is class so as type parameter we can either use Number or its child classes.
}

class Test2<T extends Runnable>{
    // since,Runnable is interface so as type parameter we can either use Runnable or its implementation classes.
}

class Test3<T extends Number & Runnable>{
    // here order is matter, first class then interface or else. CE
}

class MyClass extends Number implements Runnable{

    @Override public int intValue() { return 0; }

    @Override public long longValue() { return 0;}

    @Override public float floatValue() {   return 0;   }

    @Override public double doubleValue() {   return 0;   }

    @Override public void run() {   }
}

public class Eg2 {
    public static void main(String[] args) {

        Test1<Integer> i1 = new Test1<>();
        Test1<Double> d1 = new Test1<>();
        // Test1<String> s1 = new Test1<String>();

        Test2<Runnable> r1 = new Test2<>();
        Test2<Thread> t1 = new Test2<>();
        // Test2<String> s2 = new Test2<String>();


        Test3<MyClass> ref = new Test3<>();
    }
}
