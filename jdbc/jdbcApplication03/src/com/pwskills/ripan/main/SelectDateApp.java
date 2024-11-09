package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SelectDateApp {
    private static final String SELECT_QUERY = "select id, username, dob from users where id = ?;";
    public static void main(String[] args) {

        Connection connection = null ;
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet = null ;

        try{
            connection = DatabaseUtil.getDatabaseConnection();

            if(connection != null){
                Scanner scanner = new Scanner(System.in);
                preparedStatement = connection.prepareStatement(SELECT_QUERY);
                if(scanner != null && preparedStatement != null){
                    System.out.print("Enter the id :");
                    int id = scanner.nextInt();

                    preparedStatement.setInt(1, id);

                    resultSet = preparedStatement.executeQuery();
                }
                if(resultSet != null){
                    if(resultSet.next()){
                        System.out.println("Id\tUsername\tDob");
                        System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+
                                " "+convertToString(resultSet.getDate(3)));
                    }else {
                        System.out.println("No record found..");
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeResources(connection, preparedStatement, resultSet);
        }
    }

    private static String convertToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy"); // the format we give to the user
        return simpleDateFormat.format(date);
    }
}
