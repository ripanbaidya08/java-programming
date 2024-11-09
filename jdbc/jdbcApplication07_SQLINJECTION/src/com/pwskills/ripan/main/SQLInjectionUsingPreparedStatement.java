package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.*;
import java.util.Scanner;

public class SQLInjectionUsingPreparedStatement {
    private static final String QUERY = "select count(*) from userinfo where username = ? and password = ? " ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try(Connection connection = DatabaseUtil.getDatabaseConnection()){
            try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
                System.out.print("Enter username :");
                String username = scanner.next();

                System.out.print("Enter password :");
                String password = scanner.next();

                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);

                try(ResultSet resultSet = preparedStatement.executeQuery()){
                    int count = 0 ;
                    if (resultSet.next()){
                        count = resultSet.getInt(1);
                    }
                    if (count == 1) {
                        System.out.println("Valid Creadintials..");
                    } else {
                        System.out.println("Invalid Creadintials.. ");
                    }
                }

            }
        }catch (SQLException se){
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
