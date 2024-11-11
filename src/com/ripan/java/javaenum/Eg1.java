package com.ripan.java.javaenum;

// group of named constants

enum EColor{
    BLUE,
    GREEN,
    RED;

    void info(){
        System.out.println("universal color");
    }
}

public class Eg1 {
    public static void main(String[] args) {
        EColor[] colors = EColor.values();

        for (EColor color : colors) System.out.print(color+" "); // BLUE GREEN RED

        System.out.println();

        for(EColor color : colors) color.info(); // universal color- 3 times
    }
}
