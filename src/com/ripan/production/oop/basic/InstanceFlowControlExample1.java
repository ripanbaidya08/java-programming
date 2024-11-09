package com.ripan.production.oop.basic;

class Student1 {
    //instance variable
    int sid;
    String sname;
    int sage;

    //constructor: shadowing -> resolved through "this"
    public Student1(int sid, String sname,int sage) {
        System.out.println("Supplied values through constructor");
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
    }

    //instance block
    {
        System.out.println("Supplied values through instance block");
        sid = 100;
        sname = "dhoni";
        sage = 41;
        displayStudentDetails();
    }

    //instance method
    public void displayStudentDetails() {
        System.out.println("SID is :: "+sid);
        System.out.println("SNAME is :: "+sname);
        System.out.println("SAGE is :: "+sage);
    }
}

class InstanceFlowControlExample {
    public static void main(String[] args) {
        Student1 std = new Student1(10,"sachin",50);
        std.displayStudentDetails();
    }
}