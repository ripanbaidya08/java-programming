package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjectionUsingStatement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try(Connection connection = DatabaseUtil.getDatabaseConnection()){
            try(Statement statement = connection.createStatement()){
                System.out.print("Enter username :");
                String username = scanner.next();
                username = "'" + username + "'";

                System.out.print("Enter password :");
                String password = scanner.next();
                password = "'" + password + "'";

                String query = "select count(*) from userinfo where username = "+username+" and password = "+password+" ";

                try(ResultSet resultSet = statement.executeQuery(query)){
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
