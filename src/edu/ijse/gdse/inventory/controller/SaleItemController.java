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
import edu.ijse.gdse.inventory.model.SaleItem;
import edu.ijse.gdse.inventory.other.IDGenerator;

/**
 *
 * @author Pahansith
 */
public class SaleItemController {

    public static String getNextSaleId() throws ClassNotFoundException, SQLException {
        String sql = "select SID from sale_item order by 1 desc limit 1";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery(sql);

        if (rst.next()) {
            String currentId = rst.getString("SID");
            return IDGenerator.getNextSaleId("S", currentId);
        }
        return IDGenerator.getNextSaleId("S", null);
    }

    public static boolean addSaleItems(ArrayList<SaleItem> itemList) throws ClassNotFoundException, SQLException {
        String sql = "insert into Sale_Item values(?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        int counter = 0;
        for (SaleItem saleItem : itemList) {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setObject(1, saleItem.getSaleId());
            pstm.setObject(2, saleItem.getItemCode());
            pstm.setObject(3, saleItem.getBillNumber());
            pstm.setObject(4, saleItem.getTotalAmount());
            pstm.setObject(5, saleItem.getLabeledPrice());
            pstm.setObject(6, saleItem.getSoldPrice());
            pstm.setObject(7, saleItem.getSoldQuantity());
            pstm.setObject(8, saleItem.getDiscount());
            counter += pstm.executeUpdate();
        }
        return counter == itemList.size();
    }

    public static boolean updateSaleItem(SaleItem saleItem) throws ClassNotFoundException, SQLException {
        String sql = "update Sale_Item set Item_Code=?,Bill_No=?,Total_Amount=?,Labeled_Price=?,Sold_Price=?,Sold_QTY=?,Discount_Of_Item=? where SID =?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, saleItem.getItemCode());
        pstm.setObject(2, saleItem.getBillNumber());
        pstm.setObject(3, saleItem.getTotalAmount());
        pstm.setObject(4, saleItem.getLabeledPrice());
        pstm.setObject(5, saleItem.getSoldPrice());
        pstm.setObject(6, saleItem.getSoldQuantity());
        pstm.setObject(7, saleItem.getDiscount());
        pstm.setObject(8, saleItem.getSaleId());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean deleteSaleItem(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Sale_Item where SID='" + id + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;

    }

    public static SaleItem searchSaleItem(String saleId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Sale_Item where SID =? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, saleId);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new SaleItem(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getDouble(5), rst.getDouble(6), rst.getInt(7), rst.getDouble(8));

        }
        return null;

    }

    public static ArrayList<SaleItem> viewAllSaleItemDetails() throws ClassNotFoundException, SQLException {
        String sql = "select * from Sale_Item ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        ArrayList<SaleItem> saleItemDetailList = new ArrayList<>();
        while (rst.next()) {
            SaleItem saleItem = new SaleItem(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getDouble(5), rst.getDouble(6), rst.getInt(7), rst.getDouble(8));
            saleItemDetailList.add(saleItem);
        }
        return saleItemDetailList;
    }

}
