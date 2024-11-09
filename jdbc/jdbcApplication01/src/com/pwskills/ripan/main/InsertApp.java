package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertApp {
    private static final String INSERT_QUERY = "insert into student(sid, sname, sage, saddress) values(5, 'ramesh', 26, 'mumbai');";
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null ;
        int rowCount = 0 ;

        try{
            // Establishing the connection between the database and the java Application
            connection = DatabaseUtil.getDatabaseConnection();

            if(connection != null)
                statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);
            String sqlInsertQuery = null ;

            if(scanner != null ){

                System.out.print("Enter id : ");
                int id = scanner.nextInt();
                System.out.print("Enter name : ");
                String name = scanner.next();
                name = "'"+name+"'";
                System.out.print("Enter age : ");
                int age = scanner.nextInt();
                System.out.print("Enter address : ");
                String address = scanner.next();
                address = "'"+address+"'";

                sqlInsertQuery = "insert into student(sid, sname, sage, saddress) values("+id+","+name+","+age+","+address+")";
            }

            if(statement != null && sqlInsertQuery != null)
                rowCount = statement.executeUpdate(sqlInsertQuery);
            if(rowCount == 0)
                System.out.println("Record not inserted");
            else
                System.out.println("Record inserted successfully");

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeResources(connection, statement, null);
        }
    }
}
