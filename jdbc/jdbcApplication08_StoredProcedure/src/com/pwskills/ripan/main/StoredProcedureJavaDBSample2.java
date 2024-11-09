package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.*;
import java.util.Scanner;

/*
 * jdbc application : StoredProcedureJavaDBSample.java :
 * DB : pwskills_octbatch
 * table : products(pid, pname, price, quantity)
 */

public class StoredProcedureJavaDBSample2 {
    private static final String PROCEDURE_QUERY = "{CALL getProductDetailsByName (?, ?)}";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name1 = null ;
        String name2 = null;

        if(scan != null){
            System.out.print("Enter first and Second Name :");
            name1 = scan.next();
            name2 = scan.next();
        }
        try(Connection connection = DatabaseUtil.getDatabaseConnection()){
            System.out.println("Connection established successfully"+connection);
            try(CallableStatement callableStatement = connection.prepareCall(PROCEDURE_QUERY)){

                // Set the IN parameter value,  pid
                callableStatement.setString(1, name1);
                callableStatement.setString(2, name2);

                // execute the query ..
                callableStatement.execute();

                // collect the output ..
                try(ResultSet resultSet = callableStatement.getResultSet()){
                    System.out.println("PID"+" : "+"PNAME"+" : "+"PRICE"+" : "+"QUANTITY");
                    while (resultSet.next()){
                        System.out.println(resultSet.getInt(1)+" : "+resultSet.getString(2)+" : "+resultSet.getInt(3)+" : "+resultSet.getInt(4));
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
