package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SelectAndNonSelectApp {
    public static void main(String[] args) {

        Connection connection = null ;
        Statement statement = null ;
        ResultSet resultSet = null ;
        boolean flag = false ;  // to identify the type of query
        int rowCount = 0 ;

        try{
            // Establishing the connection
            connection = DatabaseUtil.getDatabaseConnection();

            // Create the Statement Object.
            if(connection != null)
                statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);
            String sqlQuery = null ;

            if(scanner != null){
                System.out.print("Enter the Sql Query :");
                sqlQuery = scanner.nextLine();
                scanner.close();
            }
            if(sqlQuery != null && statement != null)
                flag = statement.execute(sqlQuery);

            if(flag){
                // display result set --> Select query ..
                resultSet = statement.getResultSet();
                while(resultSet.next()){
                    System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getString(4));
                }
            } else {
                // display non result set
                rowCount = statement.getUpdateCount();
                if(rowCount == 0)
                    System.out.println("Table not modified..");
                else
                    System.out.println("table modified..");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeResources(connection, statement, resultSet);
        }
    }
}
