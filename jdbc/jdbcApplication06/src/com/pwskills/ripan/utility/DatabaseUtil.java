package com.pwskills.ripan.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public final class DatabaseUtil {

    private DatabaseUtil() {
        // user should not be able to create object of this class
    }

    private static Properties properties = null ;
    private static Properties properties2 = null ;

    static {
        FileInputStream fileInputStream1 = null;
        FileInputStream fileInputStream2 = null ;

        String firstDbPathInfo = "C:\\Users\\ripan baidya\\IdeaProjects\\jdbcApplication06\\src\\com\\pwskills\\ripan\\properties\\firstDbInfo.properties";
        String secondDbPathInfo = "C:\\Users\\ripan baidya\\IdeaProjects\\jdbcApplication06\\src\\com\\pwskills\\ripan\\properties\\secondDbInfo.properties";

        try{
            fileInputStream1 = new FileInputStream(firstDbPathInfo);
            fileInputStream2 = new FileInputStream(secondDbPathInfo);

            if(fileInputStream1 != null && fileInputStream2 != null){
                properties = new Properties();
                properties2 = new Properties();

                properties.load(fileInputStream1);
                properties2.load(fileInputStream2);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileInputStream1 != null || fileInputStream2 != null){
                try{
                    fileInputStream1.close();
                    fileInputStream2.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static Connection getFirstDatabaseConnection() throws IOException, SQLException {
        return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
    }
    public static Connection getSecondDatabaseConnection() throws IOException, SQLException {
        return DriverManager.getConnection(properties2.getProperty("url"), properties2.getProperty("user"), properties2.getProperty("password"));
    }

    public static void closeResources(Connection connection, Statement statement, ResultSet resultSet) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
