package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;
import jdk.jfr.consumer.RecordingStream;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnectionPoolDataSourceJavaDBSample {
    private static final String SELECT_QUERY = "select sid, sname, sage, saddress from student;";

    public static void main(String[] args) {

        try(Connection connection = DatabaseUtil.getDatabaseConnection()){

            try(Statement statement = connection.createStatement()){

                try(ResultSet resultSet = statement.executeQuery(SELECT_QUERY)){
                    while(resultSet.next()){
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
