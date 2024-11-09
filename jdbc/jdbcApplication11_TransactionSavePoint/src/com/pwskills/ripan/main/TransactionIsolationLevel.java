package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionIsolationLevel {
    public static void main(String[] args)  {

        try(Connection connection = DatabaseUtil.getDatabaseConnection()){
            System.out.println("Default transaction isolation "+connection.getTransactionIsolation());

            connection.setTransactionIsolation(8);

            System.out.println("Updated transaction isolation "+connection.getTransactionIsolation());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
