/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse.inventory.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pahansith
 */
public class DBConnection {

    private static DBConnection ob;

    private final Connection conn;

    private DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/Fashion_Archade_Inventory","root","1992Pws7994");
    }
    public static DBConnection getDBConnection() throws ClassNotFoundException, SQLException{
        if(ob == null){
            ob = new DBConnection();
        }
        return ob;
    }
    
    public Connection getConnection(){
        return conn;
    }
    
}