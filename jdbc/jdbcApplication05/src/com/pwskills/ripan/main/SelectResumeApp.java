package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SelectResumeApp {
    private static final String SELECT_QUERY = "select eid, ename, eaddress, resume from employee where eid = ?;";
    public static void main(String[] args) {

        Connection connection = null ;
        PreparedStatement preparedStatement = null ;
        ResultSet resultSet = null ;

        try{
            Scanner scanner = new Scanner(System.in);
            connection = DatabaseUtil.getDatabaseConnection();

            if(connection != null)
                preparedStatement = connection.prepareStatement(SELECT_QUERY);

            if(scanner != null && preparedStatement != null){
                System.out.print("Enter the id : ");
                int id = scanner.nextInt();

                preparedStatement.setInt(1, id);

                resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    System.out.println("EID\tENAME\tEADDRESS\tRESUME");

                    String resumeFileName ="resume.txt";

                    FileWriter fileWriter = new FileWriter(new File(resumeFileName));
                    IOUtils.copy(resultSet.getCharacterStream(4), fileWriter);
                    fileWriter.flush();

                    System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resumeFileName);
                }else{
                    System.out.println("Record not found");
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

    private static String convertToString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy"); // the format we give to the user
        return simpleDateFormat.format(date);
    }
}
