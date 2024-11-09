package com.pwskills.ripan.test;

// program which will demostrate the working of select and non select query
import com.pwskills.ripan.utility.DatabaseUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectAndNonSelectQueryTesting {
    private static final String SELECT_QUERY = "select sid, sname, sage, saddress from student;";

    public static void main(String[] args) {
        // select and non select query
        Connection connection = null ;
        Statement statement = null ;
        ResultSet resultSet = null ;
        boolean flag = false ;
        int rowCount = 0 ;

        try{
            connection = DatabaseUtil.getDatabaseConnection();

            if(connection != null)
                statement = connection.createStatement();
            if(statement != null)
                resultSet = statement.executeQuery(SELECT_QUERY);

            String query = null ;
            Scanner scanner = new Scanner(System.in);

            if(scanner != null){
                System.out.println("Enter the sql query : ");
                query = scanner.nextLine();
                scanner.close();
            }
            if(query != null && statement != null)
                flag = statement.execute(query);

            if(flag){
                // display result set --> select query ..
                resultSet = statement.getResultSet();
                while(resultSet.next()){
                    System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getInt(3) + " " + resultSet.getString(4));
                    rowCount++;
                }
                System.out.println("No of rows : " + rowCount);
            } else {
                rowCount = statement.getUpdateCount();
                if(rowCount == 0)
                    System.out.println("No rows affected");
                else
                    System.out.println("Row modified Successfully : ");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeResources(connection, statement, resultSet);
        }
    }
}
