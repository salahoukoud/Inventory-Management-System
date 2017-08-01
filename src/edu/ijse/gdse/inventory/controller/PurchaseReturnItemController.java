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
import edu.ijse.gdse.inventory.model.PurchaseReturnItem;

/**
 *
 * @author Pahansith
 */
public class PurchaseReturnItemController {

    public static boolean addPurchaseReturnItem(PurchaseReturnItem purchaseReturnItem) throws ClassNotFoundException, SQLException {
        String sql = "insert into Purchase_Return_Item values(?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, purchaseReturnItem.getDetailCode());
        pstm.setObject(2, purchaseReturnItem.getDateOfReturn());
        pstm.setObject(3, purchaseReturnItem.getDescription());
        pstm.setObject(4, purchaseReturnItem.getReturnQty());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean updatePurchaseReturnItem(PurchaseReturnItem purchaseReturnItem) throws ClassNotFoundException, SQLException {
        String sql = "update Purchase_Return_Item set Date_Of_Return=?,Description=?,Return_Qty=? where Detail_Code =?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, purchaseReturnItem.getDateOfReturn());
        pstm.setObject(2, purchaseReturnItem.getDescription());
        pstm.setObject(3, purchaseReturnItem.getReturnQty());
        pstm.setObject(4, purchaseReturnItem.getDetailCode());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean deletePurchaseReturnItem(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Purchase_Return_Item where Detail_Code='" + id + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;

    }

    public static PurchaseReturnItem searchPurchaseReturnItem(String purchaseReturnId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Purchase_Return_Item where Detail_Code =? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, purchaseReturnId);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new PurchaseReturnItem(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4));

        }
        return null;

    }

    public static ArrayList<PurchaseReturnItem> viewAllPurchaseReturnDetails() throws ClassNotFoundException, SQLException {
        String sql = "select * from Purchase_Return_Item ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        ArrayList<PurchaseReturnItem> purchaseDetailList = new ArrayList<>();
        while (rst.next()) {
            PurchaseReturnItem purchaseReturnItem = new PurchaseReturnItem(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4));
            purchaseDetailList.add(purchaseReturnItem);
        }
        return purchaseDetailList;
    }
}
