/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse.inventory.controller;

import edu.ijse.gdse.inventory.db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import edu.ijse.gdse.inventory.model.User;

/**
 *
 * @author Pahansith
 */
public class UserController {
    public static int addUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO User_Acount VALUES(?, password(?))";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, user.getUserName());
        stm.setObject(2, user.getPassword());
        return stm.executeUpdate();
    }
    
    public static boolean login(User user) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM User_Acount WHERE username = ? AND password = password(?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, user.getUserName());
        stm.setObject(2, user.getPassword());
        ResultSet rst = stm.executeQuery();
        return rst.next();
    }
}
