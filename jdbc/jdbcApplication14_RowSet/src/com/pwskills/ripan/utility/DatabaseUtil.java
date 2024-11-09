package com.pwskills.ripan.utility;

import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public final class DatabaseUtil {

    private DatabaseUtil() {
        // user should not be able to create object of this class
    }

    private static Properties properties = null ;
    private static MysqlConnectionPoolDataSource mysqlConnectionPoolDataSource = null ;

    static {
        FileInputStream fileInputStream = null;

        String dpPathInfo = "C:\\Users\\ripan baidya\\IdeaProjects\\jdbcApplication13_ConnectionPooling\\src\\com\\pwskills\\ripan\\properties\\database.properties";

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

        // mySql Connection pool data source..
        mysqlConnectionPoolDataSource = new MysqlConnectionPoolDataSource();
        mysqlConnectionPoolDataSource.setUrl(properties.getProperty("url"));
        mysqlConnectionPoolDataSource.setUser(properties.getProperty("user"));
        mysqlConnectionPoolDataSource.setPassword(properties.getProperty("password"));

    }
    public static Connection getDatabaseConnection() throws IOException, SQLException {
        return mysqlConnectionPoolDataSource.getConnection();
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
