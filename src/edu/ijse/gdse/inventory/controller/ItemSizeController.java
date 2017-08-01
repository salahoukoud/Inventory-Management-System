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
import edu.ijse.gdse.inventory.model.SizeOfItem;

/**
 *
 * @author Pahansith
 */
public class ItemSizeController {

    public static boolean addSizeOfItem(SizeOfItem sizeOfItem) throws ClassNotFoundException, SQLException {
        String sql = "insert into Size_Of_Item values(?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, sizeOfItem.getSizeId());
        pstm.setObject(2, sizeOfItem.getItemSize());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean updateSizeOfItem(SizeOfItem sizeOfItem) throws ClassNotFoundException, SQLException {
        String sql = "update Size_Of_Item set Item_Size=? where Size_ID =?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, sizeOfItem.getItemSize());
        pstm.setObject(2, sizeOfItem.getSizeId());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean deleteSizeOfItem(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Size_Of_Item where Size_ID='" + id + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;

    }

    public static SizeOfItem searchSizeOfItemDetail(String SizeOfItemId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Size_Of_Item where Size_ID =? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, SizeOfItemId);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new SizeOfItem(rst.getString(1), rst.getString(2));

        }
        return null;

    }

    public static ArrayList<SizeOfItem> viewAllSizeOfItemsDetails() throws ClassNotFoundException, SQLException {
        String sql = "select * from Size_Of_Item ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        ArrayList<SizeOfItem> sizeOfItemDetailList = new ArrayList<>();
        while (rst.next()) {
            SizeOfItem sizeOfItemDetail = new SizeOfItem(rst.getString(1), rst.getString(2));
            sizeOfItemDetailList.add(sizeOfItemDetail);
        }
        return sizeOfItemDetailList;
    }
}
