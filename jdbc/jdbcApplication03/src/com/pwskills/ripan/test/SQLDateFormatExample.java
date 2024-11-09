package com.pwskills.ripan.test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SQLDateFormatExample {
    public static void main(String[] args) throws Exception{
        System.out.println("Enter the data in the given format :: dd-MM-yyyy");
        String userDate = new Scanner(System.in).next();

        System.out.println("Original Date :" + userDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        // parse the user entered date into util date
        java.util.Date utilDate = simpleDateFormat.parse(userDate);
        // get the time
        Long inputInMillis = utilDate.getTime();

        // convert the date into sql supported aate
        java.sql.Date sqlDate = new Date(inputInMillis);

        System.out.println("SQL Date :" + sqlDate);
    }
}
