package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetUpdateApp {
    public static void main(String[] args) {
        try(Connection connection = DatabaseUtil.getDatabaseConnection()){

            try(Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){

                try(ResultSet resultSet = statement.executeQuery("select * from student;")){

                    while (resultSet.next()){
                        String name = resultSet.getString(2);

                        if(name.equals("ryan"))
                            resultSet.updateString(2,"ripan baidya");
                        resultSet.updateRow();
                    }
                    System.out.println("Updation Successful");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
