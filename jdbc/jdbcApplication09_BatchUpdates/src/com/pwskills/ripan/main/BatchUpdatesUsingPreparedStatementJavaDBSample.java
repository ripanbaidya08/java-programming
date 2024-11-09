package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchUpdatesUsingPreparedStatementJavaDBSample {

    private static final String SQL_INSERT_QUERY = "insert into student (sid, sname, sage, saddress) values (?, ?, ?, ?)";
    public static void main(String[] args) {

        try(Connection connection = DatabaseUtil.getDatabaseConnection()){

            try(PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_QUERY)){
                Scanner scan = new Scanner(System.in);
                if(scan != null){
                    while(true){
                        System.out.print("Enter student Id : ");
                        preparedStatement.setInt(1, scan.nextInt());

                        System.out.print("Enter student Name : ");
                        preparedStatement.setString(2, scan.next());

                        System.out.println("Enter Student Age : ");
                        preparedStatement.setInt(3, scan.nextInt());

                        System.out.println("Enter Student Address : ");
                        preparedStatement.setString(4, scan.next());

                        // now, add the batch.
                        preparedStatement.addBatch();

                        System.out.println("Do you want to continue(y/n) : ");
                        if(scan.next().equalsIgnoreCase("n")){
                            break;
                        }
                    }
                    // execute the batch.
                    preparedStatement.executeUpdate();

                    System.out.println("Batch executed successfully");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
