package com.pwskills.ripan.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class MainApp {
    public static void main(String[] args) {

        Connection connection = null ;
        FileInputStream fileInputStream = null ;
        Statement statement = null ;
        ResultSet resultSet = null ;

        try{
            // String and file related information
            String dbInformation = "C:\\Users\\ripan baidya\\IdeaProjects\\jdbcApplication01\\src\\com\\pwskills\\ripan\\properties\\database.properties";
            fileInputStream = new FileInputStream(dbInformation);
            Properties properties= new Properties();
            properties.load(fileInputStream);   // load the properties file

            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");

            // 1. Establishing connection between the java application and the database.
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successfull");

            // 2. Create Statement Object
            statement = connection.createStatement();
            System.out.println("Statement object is Created..");

            // 3. Execute The queru, executeQuery() --> select query
            String query = "select sid, sname, sage, saddress from student";
            resultSet = statement.executeQuery(query);
            System.out.println("ResultSet object got created..");

            // 4. Process Result
            System.out.println("\nsid\tsname\tsage\tsaddress");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if(connection != null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(fileInputStream != null){
                try{
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if(statement != null){
                try{
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(resultSet != null){
                try{
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
