package com.pwskills.ripan.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SampleDateDemo {
    public static void main(String[] args) throws ParseException {
        String indianDate = "24-05-2022";   // dd-MM-yyyy
        String chinaDate = "2022-05-24";   // yyyy-MM-dd

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date utilDate = simpleDateFormat.parse(indianDate);
        Long inputInMillis = utilDate.getTime();

        java.sql.Date sqlDate = new java.sql.Date(inputInMillis);
        System.out.println("SQL Date: " + sqlDate);


        // if the user input format is already :: yyyy-MM-dd
        java.sql.Date sqlDate2 = java.sql.Date.valueOf(chinaDate);
        System.out.println("SQL Date: " + sqlDate2);
    }
}
