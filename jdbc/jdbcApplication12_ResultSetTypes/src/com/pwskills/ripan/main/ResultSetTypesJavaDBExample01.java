package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTypesJavaDBExample01 {
    public static void main(String[] args) {

        try(Connection connection = DatabaseUtil.getDatabaseConnection()){

            try(Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){

                try(ResultSet resultSet = statement.executeQuery("select * from student;")){
                    System.out.println("Default printing..");
                    System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
                    while (resultSet.next()){
                        System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
                    }
                    System.out.println("printing a Particular row ..");

                    resultSet.first(); // cursor at the first position.

                    resultSet.relative(3); // print the 3rd row
                        System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
