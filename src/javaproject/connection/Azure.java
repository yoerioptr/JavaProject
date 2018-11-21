/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject.connection;

import java.awt.Color;
import java.sql.*;
import java.util.Properties;
import javaproject.Photo;

/**
 *
 * @author Yoeri
 */
public class Azure {
    private Connection connection = null;
    
    public Azure() {
        /* Load the driver */
        try{ Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); }
        catch (ClassNotFoundException e) {
            System.err.println(e.toString());
        }
        
        /* Connect */
        try
        {
            String url = "jdbc:sqlserver://ittoolsiot.database.windows.net:1433;database=Java_Project;user=r0663911@ittoolsiot;password=LcDY9A3u8Fx3fym9JUjVJWpLchQqar;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            
            connection = DriverManager.getConnection(url);
        }
        catch (SQLException e) {
            System.err.println(e.toString());
        }
        
        /* Create Database */
        createTableIfNotExist();
    }
    
    private void createTableIfNotExist() {
        try {
            Statement statement = connection.createStatement();
            String SQL = "CREATE TABLE table_data ("
                + "id int PRIMARY KEY NOT NULL IDENTITY(1,1),"
                    + "column_0 varchar(50),"
                    + "column_1 int,"
                    + "column_2 BIT,"
                    //+ "comumn_3 varchar(7),"
                    + "column_4 varbinary(max)"
                + ");";
            statement.execute(SQL);
        } 
        catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
    public void addRow(String textValue, int numberValue, boolean bitValue, Photo photo) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO table_data "
                + "VALUES ("
                    + textValue + ","
                    + numberValue + ","
                    + bitValue + ","
                    + photo.getPhotoByteArray()
                + ");";
            statement.execute(SQL);
        } 
        catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    
    public void updateText(int rowIndex, String textValue) {
        try {
            Statement statement = connection.createStatement();
            String SQL = "UPDATE table_data "
                    + "SET column_0='" + textValue + "' "
                    + "WHERE id=" + rowIndex + ";";
            statement.execute(SQL);
        } 
        catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
