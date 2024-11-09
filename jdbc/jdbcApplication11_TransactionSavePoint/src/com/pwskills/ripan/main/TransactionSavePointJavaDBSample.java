package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.*;
import java.util.Scanner;

public class TransactionSavePointJavaDBSample {

    public static void main(String[] args) {

        try(Connection connection = DatabaseUtil.getDatabaseConnection()){

            try(Statement statement = connection.createStatement()){

                connection.setAutoCommit(false);

                statement.executeUpdate("insert into politicians values('modi', 'bjp')");
                statement.executeUpdate("insert into politicians values('rahul', 'congress')");

                Savepoint savepoint = connection.setSavepoint(); // we save the set point
                statement.executeUpdate("insert into politicians values('siddu', 'bjp')"); // we want this statment to roll back

                System.out.println("Something went wrong...");
                connection.rollback(savepoint);

                connection.commit();
                System.out.println("Connection commited.");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
