/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject.connection;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author Yoeri
 */
public class DatabaseConnection {
    
    private Connection connection = null;
    
    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (final ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            connection = (java.sql.Connection) java.sql.DriverManager
                .getConnection("jdbc:mysql://localhost:3306/java_project", "root", "");

        } catch ( Exception e ) {
            System.out.println( e.toString() );
        }
        
        createTableIfNotExists();
    }
    
    private void createTableIfNotExists() {
        try {
            Statement statement = connection.createStatement();
            
            String SQL = "CREATE TABLE table_data ("
                + "id int PRIMARY KEY NOT NULL AUTO_INCREMENT,"
                + "column_0 varchar(50),"
                + "column_1 int,"
                + "column_2 BIT,"
                + "column_3 blob"
                + ");";
            
            statement.execute(SQL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet excecuteQuery(String query) {
        ResultSet rs = null;
        
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return rs;
    }
}
