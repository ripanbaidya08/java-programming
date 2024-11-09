package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.io.IOException;
import java.sql.*;

// copy records from hdfc to sbi

public class CopyRecordsFromOneDBToAnotherDB {
    private static final String SELECT_QUERY = "select accno, holdername, balance from hdfc;";
    private static final String INSERT_QUERY = "insert into sbi (accno, holdername, balance) values (?, ?, ?);";

    public static void main(String[] args) {

        Connection firstDBConnection = null ;
        Connection secondDBConnection = null ;

        Statement statement = null ; // select query, read the records from the bank1 db, table hdfc  --> read
        PreparedStatement preparedStatement = null ; // insert query, write the records to the bank2 db, table sbi --> write

        ResultSet resultSet = null ;

        try{
            firstDBConnection = DatabaseUtil.getFirstDatabaseConnection();
            secondDBConnection = DatabaseUtil.getSecondDatabaseConnection();

            System.out.println("Connection established.. ");

            if(firstDBConnection != null ){
                System.out.println("Create statatement object for first database..");
                statement = firstDBConnection.createStatement();
            }
            if(secondDBConnection != null){
                System.out.println("Create preparedStatement object for second database..");
                preparedStatement = secondDBConnection.prepareStatement(INSERT_QUERY);
            }
            System.out.println("Executing query for the first db table hdfc.. ");
            resultSet = statement.executeQuery(SELECT_QUERY);

            if(resultSet != null){ // read the records from the hdfc table
                while (resultSet.next()){
                    preparedStatement.setInt(1, resultSet.getInt(1));
                    preparedStatement.setString(2, resultSet.getString(2));
                    preparedStatement.setFloat(3, resultSet.getFloat(3));

                    preparedStatement.executeUpdate();

                }
                System.out.println("\nRecord Successfully Copies from hdfc table to sbi bank table.. ");
            }
        }catch (SQLException | IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // closing the resources for the hdfc table, used re
            DatabaseUtil.closeResources(firstDBConnection, statement, resultSet);

            // closing the resources for the sbi table
            DatabaseUtil.closeResources(secondDBConnection, preparedStatement, null);

        }
    }
}
