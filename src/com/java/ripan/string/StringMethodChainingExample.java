package com.java.ripan.string;

public class StringMethodChainingExample {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        sb.append("sachin").insert(6, "tendulkar").reverse().append("IND").delete(0, 4).reverse();
        System.out.println(sb);

    }
}
