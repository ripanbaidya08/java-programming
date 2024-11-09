package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteApp {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null ;
        int rowCount = 0 ;

        try{
            connection = DatabaseUtil.getDatabaseConnection();

            if(connection != null)
                statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);
            String sqlDeleteQuery = null ;

            if(scanner != null ){

                System.out.print("Enter id you want to delete the record: ");
                int id = scanner.nextInt();

                sqlDeleteQuery = "delete from student where sid = "+id+"";
            }

            if(statement != null && sqlDeleteQuery != null)
                rowCount = statement.executeUpdate(sqlDeleteQuery);
            if(rowCount == 0)
                System.out.println("Record not deleted");
            else
                System.out.println("Record deleted successfully");

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtil.closeResources(connection, statement, null);
        }
    }
}
