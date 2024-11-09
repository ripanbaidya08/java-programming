package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdatesUsingStatementJavaDBSample {
    public static void main(String[] args) {

        try(Connection connection = DatabaseUtil.getDatabaseConnection()){

            try(Statement statement = connection.createStatement()){
                // first we will work with statement object .

                // add batch
                statement.addBatch("insert into student (sid, sname, sage, saddress) values (10, 'hamza', 27, 'dubai')");  // insert
                statement.addBatch("update student set sname = 'ryan' where sid = 1"); // update
                statement.addBatch(("delete from student where sid = 6")); // delete

                // execute the batch
                int [] result = statement.executeBatch(); // return type is array

                // process the result, means how many rows get affected..
                int rowCount = 0;
                for(int res : result){
                    rowCount += res;
                }
                System.out.println("Number of Rows affected.."+rowCount);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
