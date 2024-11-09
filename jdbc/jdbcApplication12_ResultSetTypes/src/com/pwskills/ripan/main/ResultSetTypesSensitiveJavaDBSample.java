package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetTypesSensitiveJavaDBSample {
    public static void main(String[] args) {
        try(Connection connection = DatabaseUtil.getDatabaseConnection()){

            try(Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){

                try(ResultSet resultSet = statement.executeQuery("select * from student;")){

                    System.out.println("Before the Operation ..");
                    System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
                    while (resultSet.next()){
                        System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
                    }

                    System.out.println();
                    System.out.println("Application is in the pausing State, Operation happening on the database....");
                    System.in.read();

                    resultSet.beforeFirst();

                    System.out.println("After the Operation ..");
                    System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
                    while (resultSet.next()){
                        resultSet.refreshRow(); // refresh the row
                        System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getInt(3)+"\t"+resultSet.getString(4));
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
