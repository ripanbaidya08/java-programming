package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.*;
import java.util.Scanner;

public class TransactionJavaDBSample {

    public static void main(String[] args) {

        try(Connection connection = DatabaseUtil.getDatabaseConnection()){

            try(Statement statement = connection.createStatement()){

                try(ResultSet resultSet = statement.executeQuery("Select * from Accounts;")){
                    System.out.println("Before The Transaction..");
                    while (resultSet.next()){
                        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
                    }
                }

                // 1. start transaction
                connection.setAutoCommit(false);
                /*
                * Table : Accounts.. Ripan and Raghav..
                * Transfer will happen from [ ripan --> raghav ]
                * Transaction for 5000
                 */
                statement.executeUpdate("update Accounts set balance = balance - 5000 where name = 'ripan';"); // money will deduct from ripan
                statement.executeUpdate("update Accounts set balance = balance + 5000 where name = 'raghav';"); // money will add to raghav

                Scanner scanner = new Scanner(System.in);
                if(scanner != null){
                    System.out.println("Do you want to perform the Tansaction [yes/no]");
                    String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("yes")){
                        connection.commit();
                        System.out.println("Transaction is successful");
                    }else{
                        connection.rollback();
                        System.out.println("Transaction is failed");
                    }
                    scanner.close();
                }
                try(ResultSet resultSet = statement.executeQuery("Select * from Accounts;")){
                    System.out.println("After The Transaction..");
                    while (resultSet.next()){
                        System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
                    }
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
