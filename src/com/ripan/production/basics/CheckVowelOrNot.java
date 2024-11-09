package com.ripan.production.basics;

// check whether a character is vowel or not.

public class CheckVowelOrNot {
    public static void main(String[] args) {

        char ch = 'a';

        // vowel = a, e, i, o, u

        if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O'|| ch == 'u' || ch == 'U')
            System.out.println("vowel");
        else
            System.out.println("not vowel");
    }
}
