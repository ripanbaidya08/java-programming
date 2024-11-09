package com.pwskills.ripan.main;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class JdbcRowSetDBSample {
    public static void main(String[] args) {

        // JdbcRowSet --> CONCUR_UPDATABLE , TYPE_SCROOL_SENSETIVE
        JdbcRowSet jdbcRowSet = null ;
        try{

            RowSetFactory rowSetFactory = RowSetProvider.newFactory();

            jdbcRowSet = rowSetFactory.createJdbcRowSet();

            jdbcRowSet.setUrl("jdbc:mysql://localhost:3306/pwskills_octbatch");
            jdbcRowSet.setUsername("root");
            jdbcRowSet.setPassword("root123");

            jdbcRowSet.setCommand("select sid, sname, sage, saddress from student");
            jdbcRowSet.execute();

            System.out.println("Student Details in Forward Direction");

            System.out.println("SID\tSNAME\tSAGE\tSADDR");
            while(jdbcRowSet.next()){
                System.out.println(jdbcRowSet.getInt(1) + "\t" + jdbcRowSet.getString(2) + "\t" + jdbcRowSet.getInt(3)+"\t"+jdbcRowSet.getString(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
