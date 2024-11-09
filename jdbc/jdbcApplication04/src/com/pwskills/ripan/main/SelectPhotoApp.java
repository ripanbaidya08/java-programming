package com.pwskills.ripan.main;

import com.pwskills.ripan.utility.DatabaseUtil;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SelectPhotoApp {
    private static final String SELECT_QUERY = "select id, name, photo from person where id = ?;";
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
                System.out.println("Enter the id : ");
                int id = scanner.nextInt();

                preparedStatement.setInt(1, id);

                resultSet = preparedStatement.executeQuery();

                if(resultSet.next()){
                    System.out.println("ID\tNAME\tPHOTO");
                    String imageName ="download.jpg";

                    /* copy(source, destination)
                     * source : inputStream --> resultSet.getBinaryStream(3)
                     * destination : outputStream --> new FileOutputStream(imageName)
                     */
                    IOUtils.copy(resultSet.getBinaryStream(3), new FileOutputStream(imageName));

                    System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+imageName);
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
