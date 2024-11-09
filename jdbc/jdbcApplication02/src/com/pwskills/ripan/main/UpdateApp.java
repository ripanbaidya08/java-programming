package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateApp {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null ;
        int rowCount = 0 ;

        try{
            connection = DatabaseUtil.getDatabaseConnection();

            if(connection != null)
                statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);
            String sqlUpdateQuery = null ;

            if(scanner != null ){

                System.out.print("Enter id you want to make change : ");
                int id = scanner.nextInt();
                System.out.print("Enter name : ");
                String name = scanner.next();
                name = "'"+name+"'";

                sqlUpdateQuery = "update student set sname = "+name+" where sid = "+id+"";

                scanner.close();
            }

            if(statement != null && sqlUpdateQuery != null)
                rowCount = statement.executeUpdate(sqlUpdateQuery);
            if(rowCount == 0)
                System.out.println("Record not updated");
            else
                System.out.println("Record updated successfully");

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeResources(connection, statement, null);
        }
    }
}
