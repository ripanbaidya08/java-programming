package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertApp {
    private static final String INSERT_QUERY = "insert into student(sid, sname, sage, saddress) values(?,?,?,?);";
    public static void main(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null ;
        int rowCount = 0 ;

        try{
            // Establishing the connection between the database and the java Application
            connection = DatabaseUtil.getDatabaseConnection();

            if(connection != null)
                preparedStatement = connection.prepareStatement(INSERT_QUERY);

            Scanner scanner = new Scanner(System.in);

            if(scanner != null && preparedStatement != null){

                System.out.print("Enter id : ");
                int id = scanner.nextInt();

                System.out.print("Enter name : ");
                String name = scanner.next();

                System.out.print("Enter age : ");
                int age = scanner.nextInt();

                System.out.print("Enter address : ");
                String address = scanner.next();

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, name);
                preparedStatement.setInt(3, age);
                preparedStatement.setString(4, address);

                rowCount = preparedStatement.executeUpdate();

                if(rowCount == 0)
                    System.out.println("Insertion Failed");
                else
                    System.out.println("Insertion Successful");

                scanner.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeResources(connection, preparedStatement, null);
        }
    }
}
