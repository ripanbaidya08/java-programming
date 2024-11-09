package com.pwskills.ripan.main;

// we will working with date format ..
// for image :: setBinaryStream ..
import com.pwskills.ripan.utility.DatabaseUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertPhotoApp {

    private static final String INSERT_QUERY = "insert into person(name, photo) values(?,?);";

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

                System.out.print("Enter the name : ");
                String name = scanner.next();

                String imageFileInfo = "C:\\images\\picsart\\ripan.jpg";

                preparedStatement.setString(1, name);
                // to insert photos in the database
                preparedStatement.setBinaryStream(2,new FileInputStream(imageFileInfo));

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

    private static Date convertToSqlDate(String dob) throws ParseException {
        // SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy"); // the format typed by user
        java.util.Date utilDate = simpleDateFormat.parse(dob);
        Long inputInMillis = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(inputInMillis);
        return sqlDate;
    }
}
