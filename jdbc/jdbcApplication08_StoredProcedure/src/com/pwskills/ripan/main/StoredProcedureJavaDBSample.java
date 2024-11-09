package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/*
 * jdbc application : StoredProcedureJavaDBSample.java :
 * DB : pwskills_octbatch
 * table : products(pid, pname, price, quantity)
 */

public class StoredProcedureJavaDBSample {
    private static final String PROCEDURE_QUERY = "{CALL GET_PRODUCT_DETAILS_BY_ID (?, ?, ?, ?)}";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int id = 0;

        if(scan != null){
            System.out.print("Enter product id :");
            id = scan.nextInt();
        }
        try(Connection connection = DatabaseUtil.getDatabaseConnection()){
            System.out.println("Connection established successfully"+connection);
            try(CallableStatement callableStatement = connection.prepareCall(PROCEDURE_QUERY)){

                // Set the IN parameter value,  pid
                callableStatement.setInt(1, id);

                // Registering the OUT parmas ..
                callableStatement.registerOutParameter(2, Types.VARCHAR); // pname
                callableStatement.registerOutParameter(3, Types.INTEGER); // price
                callableStatement.registerOutParameter(4, Types.INTEGER); // quantity

                // execute the query ..
                callableStatement.execute();

                // get the output
                System.out.println("PNAME"+" : "+"PRICE"+" : "+"QUANTITY");
                System.out.println(callableStatement.getString(2)+" : "+callableStatement.getInt(3)+" : "+callableStatement.getInt(4));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
