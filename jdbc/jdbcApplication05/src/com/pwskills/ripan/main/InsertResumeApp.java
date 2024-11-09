package com.pwskills.ripan.main;

// we will working with date format ..

import com.pwskills.ripan.utility.DatabaseUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertResumeApp {

    private static final String INSERT_QUERY = "insert into employee(ename, eaddress, resume) values(?,?,?);";

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

                System.out.print("Enter the Employee Name : ");
                String name = scanner.next();

                System.out.print("Enter the address : ");
                String address = scanner.next();

                String resumeFileInfo = "C:\\ripan\\notepad\\Java Revision.txt";
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, address);

                // to insert text file in the database
                preparedStatement.setCharacterStream(3, new FileReader(new File(resumeFileInfo)));

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
