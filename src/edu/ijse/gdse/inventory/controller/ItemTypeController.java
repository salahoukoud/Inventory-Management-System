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
import java.sql.Statement;
import java.util.ArrayList;
import edu.ijse.gdse.inventory.model.ItemType;

/**
 *
 * @author Pahansith
 */
public class ItemTypeController {

    public static ItemType searchItemType(String typeId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Item_Type where Type_Id = '" + typeId + "' ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);

        if (rst.next()) {
            ItemType type = new ItemType(rst.getString(1), rst.getString(2));
            return type;
        }
        return null;
    }

    public static boolean addItemType(ItemType itemType) throws ClassNotFoundException, SQLException {
        String sql = "insert into Item_Type values(?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, itemType.getTypeId());
        pstm.setObject(2, itemType.getTypeName());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean updateItemType(ItemType itemType) throws ClassNotFoundException, SQLException {
        String sql = "update Item_Type set Type_Name=? where Type_Id=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, itemType.getTypeName());
        pstm.setObject(2, itemType.getTypeId());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean deleteItemType(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Item_Type where Type_Id ='" + id + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;

    }

    public static ArrayList<ItemType> viewAllItemTypeDetails() throws ClassNotFoundException, SQLException {
        String sql = "select * from Item_Type ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        ArrayList<ItemType> itemTypeDetailList = new ArrayList<>();
        while (rst.next()) {
            ItemType itemType = new ItemType(rst.getString(1), rst.getString(2));
            itemTypeDetailList.add(itemType);
        }
        return itemTypeDetailList;
    }
}
