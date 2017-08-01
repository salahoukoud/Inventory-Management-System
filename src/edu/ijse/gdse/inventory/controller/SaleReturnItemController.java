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
import java.util.ArrayList;
import edu.ijse.gdse.inventory.model.SaleReturnItem;

/**
 *
 * @author Pahansith
 */
public class SaleReturnItemController {

    public static boolean addSalesReturnItem(SaleReturnItem saleReturnItem) throws ClassNotFoundException, SQLException {
        String sql = "insert into Sale_Return_Item values(?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, saleReturnItem.getSaleId());
        pstm.setObject(2, saleReturnItem.getQuantity());
        pstm.setObject(3, saleReturnItem.getReturnDate());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static SaleReturnItem searchSalesReturnItem(String salesReturnId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Sale_Return_Item where SID =? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, salesReturnId);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new SaleReturnItem(rst.getString(1), rst.getInt(2), rst.getString(3));

        }
        return null;

    }

    public static ArrayList<SaleReturnItem> viewAllPurchaseReturnDetails() throws ClassNotFoundException, SQLException {
        String sql = "select * from Sale_Return_Item ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        ArrayList<SaleReturnItem> saleDetailList = new ArrayList<>();
        while (rst.next()) {
            SaleReturnItem saleReturnItem = new SaleReturnItem(rst.getString(1), rst.getInt(2), rst.getString(3));
            saleDetailList.add(saleReturnItem);
        }
        return saleDetailList;
    }
}
