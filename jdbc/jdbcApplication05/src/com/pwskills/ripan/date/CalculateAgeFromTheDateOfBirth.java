package com.pwskills.ripan.date;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CalculateAgeFromTheDateOfBirth {

    private static final String QUERY_FOR_DATE_OF_BIRTH = "select DATE_FORMAT(from_days(datediff(now(),dob)),'%Y') as AGE from users where id = ?;";

    public static void main(String[] args) {

        Connection connection = null ;
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet = null ;

        try{
            Scanner scan = new Scanner(System.in);
            connection = DatabaseUtil.getDatabaseConnection();

            if(connection != null){
                preparedStatement = connection.prepareStatement(QUERY_FOR_DATE_OF_BIRTH);
            }
            if(scan != null && preparedStatement != null){
                System.out.println("Enter the id :");
                int id = scan.nextInt();
                preparedStatement.setInt(1, id);
            }
            if(preparedStatement != null && QUERY_FOR_DATE_OF_BIRTH != null){
                resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    System.out.println("Age is : "+resultSet.getInt(1));
                } else{
                    System.out.println("No record found ..");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DatabaseUtil.closeResources(connection, preparedStatement, resultSet);
        }
    }
}
