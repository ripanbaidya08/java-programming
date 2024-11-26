package com.java.ripan.basics;

// print the day based on the no. like -> 1 for monday, 2 for tuesday and so on.

public class DayFinder {
    public static void main(String[] args) {

        int dayNo = 2;

        switch (dayNo){
            case 1:
                System.out.println("monday");
                break;
            case 2:
                System.out.println("tuesday");
                break;
            case 3:
                System.out.println("wednesday");
                break;
            case 4:
                System.out.println("thursday");
                break;
            case 5:
                System.out.println("friday");
                break;
            case 6:
                System.out.println("saturday");
                break;
            case 7:
                System.out.println("sunday");
                break;
            default:
                System.out.println("please select correct day no.");

        }
    }
}
