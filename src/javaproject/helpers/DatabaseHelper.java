/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject.helpers;

import java.sql.Blob;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javaproject.Photo;
import javaproject.connection.DatabaseConnection;
import javax.imageio.ImageIO;

/**
 *
 * @author Yoeri
 */
public class DatabaseHelper {
    private DatabaseConnection connection;
   
    public DatabaseHelper() {
        connection = new DatabaseConnection();
    }
    
    public ArrayList<Vector> getAllData() {
        ArrayList<Vector> rows = new ArrayList<Vector>();
        
        String query = "SELECT * FROM table_data";
        
        try {
            ResultSet rs = connection.excecuteQuery(query);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("column_0"));
                row.add(rs.getInt("column_1"));
                row.add(rs.getBoolean("column_2"));
                // row.add(new Photo(rs.getBlob("column_3").getBinaryStream()));
                
                rows.add(row);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        
        return rows;
    }
}
