package com.ripan.java.javaenum;

enum EColor2 {
    BLUE,
    RED{
        public void info(){
            System.out.println("Dangerous Colour");
        }

    },GREEN;
    public void info(){
        System.out.println("Universal Colour");
    }
}
public class Eg2 {
    public static void main(String[] args) {

        EColor2[] colours = EColor2.values();

        for (EColor2 color:colours ) {
            color.info();
        }
    }
}

