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

    static {
        FileInputStream fileInputStream = null;

        String dpPathInfo = "C:\\Users\\ripan baidya\\IdeaProjects\\jdbcApplication05\\src\\com\\pwskills\\ripan\\properties\\database.properties";

        try{
            fileInputStream = new FileInputStream(dpPathInfo);
            if(fileInputStream != null){
                properties = new Properties();
                properties.load(fileInputStream);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try{
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static Connection getDatabaseConnection() throws IOException, SQLException {
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url, user, password);
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
