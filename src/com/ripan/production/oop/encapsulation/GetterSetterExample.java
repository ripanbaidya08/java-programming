package com.ripan.production.oop.encapsulation;

class Calculation{
    private int num1;
    private int num2;

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }
}
public class GetterSetterExample {
    public static void main(String[] args) {

        int num1 = 10, num2 = 20;

        Calculation calc = new Calculation();

        calc.setNum1(num1);
        calc.setNum2(num2);

        int sum = calc.getNum1() + calc.getNum2();

        System.out.println("sum is: "+sum);
    }
}
