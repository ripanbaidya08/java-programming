package com.pwskills.ripan.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
    public static void main(String[] args) {
        String sqlDate = "2022-05-24";

        SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat userDateFormat = new SimpleDateFormat("dd MMM yyyy");

        try {
            Date date = sqlDateFormat.parse(sqlDate);
            String formattedDate = userDateFormat.format(date);
            System.out.println("The formatted date: " + formattedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}