package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteApp {

    private static final String DELETE_QUERY ="delete from student where sid = ?;";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null ;
        int rowCount = 0 ;

        try{
            connection = DatabaseUtil.getDatabaseConnection();

            if(connection != null)
                preparedStatement = connection.prepareStatement(DELETE_QUERY);

            Scanner scanner = new Scanner(System.in);

            if(scanner != null && preparedStatement != null){

                System.out.print("Enter id you want to delete the record: ");
                int id = scanner.nextInt();

                preparedStatement.setInt(1, id);

                rowCount = preparedStatement.executeUpdate();

                if(rowCount == 0)
                    System.out.println("Record not deleted");
                else
                    System.out.println("Record deleted successfully");
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
