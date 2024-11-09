package com.pwskills.ripan.test;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectNonSelectApp {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Connection connection = null ;
        Statement statement = null ;
        boolean flag = false ;

        try{
            if(connection == null)
                connection = DatabaseUtil.getDatabaseConnection();
            if(connection != null)
                statement = connection.createStatement();

            System.out.println("Enter the query : ");
            String query = scan.next();
            if(statement != null && query != null){
                flag = statement.execute(query);
            }
            if(flag){
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()){
                    System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3));
                }
            }else{
                int rowCount = statement.getUpdateCount();

                if(rowCount == 1)
                    System.out.println("Rows modifieed "+rowCount);
                else
                    System.out.println("no operation.. ");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
