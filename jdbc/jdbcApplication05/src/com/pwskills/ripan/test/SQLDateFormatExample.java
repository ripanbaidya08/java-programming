package com.pwskills.ripan.test;

import java.text.SimpleDateFormat;

public class SQLDateFormatExample {
    public static void main(String[] args) throws Exception{
        String indianDate = "12-11-2004";

        System.out.println("Inputed normal date : "+indianDate);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(indianDate);
        java.util.Date utilDate = simpleDateFormat.parse(indianDate);
        Long inputLongTime = utilDate.getTime();

        java.sql.Date sqlDate = new java.sql.Date(inputLongTime);
        System.out.println("SQL formated date : "+sqlDate);
    }
}
