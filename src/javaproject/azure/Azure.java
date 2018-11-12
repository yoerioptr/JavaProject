/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject.azure;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Yoeri
 */
public class Azure {
    /* Properties for database connection */
    private String Hostname;
    private String DatabaseName;
    private String Server;
    private String User;
    private String Password;
    
    /* Database url */
    private String Url;
    
    /* Connection */
    private Connection connection;
    
    public Azure(String hostname, String databaseName, String server, String user, String password) {
        /* Get the parameters */
        this.Hostname = hostname;
        this.DatabaseName = databaseName;
        this.Server = server;
        this.User = user;
        this.Password = password;
        
        /* Create the connection url */
        this.Url = String.format("jdbc:sqlserver://%s:1433;database=Java_Project;user=%s@%s;password=%s;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", this.Hostname, this.DatabaseName, this.Server, this.User, this.Password);
    }
    
    public boolean Connect() {
        try {
            /* Get theconnection */
            connection = DriverManager.getConnection(this.Url);
            
            String schema = connection.getSchema();
            
            /* Close the connection */
            connection.close();
            
            return true;
        } 
        catch (Exception e) {
            return false;
        }
    }
}
