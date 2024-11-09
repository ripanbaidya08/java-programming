package com.pwskills.ripan.main;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jdk.jfr.consumer.RecordingStream;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HikariCpConfigurationJdbcDBSample {

    private static final String SELECT_QUERY = "select sid,sname,sage,saddress from student";

    public static void main(String[] args) {

        String fileInfo = "C:\\Users\\ripan baidya\\IdeaProjects\\jdbcApplication13_ConnectionPooling\\src\\com\\pwskills\\ripan\\properties\\hikaricp.properties";
        HikariConfig hikariConfig = new HikariConfig(fileInfo);

        try(HikariDataSource dataSource = new HikariDataSource(hikariConfig)){

            try(Connection connection = dataSource.getConnection()){

                try(Statement statement = connection.createStatement()){

                    try(ResultSet resultSet = statement.executeQuery(SELECT_QUERY)){

                        System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
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
}
