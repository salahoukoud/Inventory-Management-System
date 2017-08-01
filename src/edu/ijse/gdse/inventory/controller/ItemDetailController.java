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
import java.util.HashMap;
import java.util.Iterator;
import edu.ijse.gdse.inventory.model.ItemDetail;
import edu.ijse.gdse.inventory.other.IDGenerator;

/**
 *
 * @author Pahansith
 */
public class ItemDetailController {
    public static ItemDetail getItemDetail(String detailCode) throws ClassNotFoundException, SQLException{
        String sql = "select * from Item_Detail where Detail_Code = '"+detailCode+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery(sql);
        if(rst.next()){
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setDetailCode(rst.getString(1));
            itemDetail.setInvoiceNumber(rst.getString(2));
            itemDetail.setItemCode(rst.getString(3));
            itemDetail.setBuyingPrice(rst.getDouble(4));
            itemDetail.setQtyOfEachItem(rst.getInt(5));
            itemDetail.setSupplierCode(rst.getString(7));
        }
        return null;
    }
    
    public static String getNextItemDetailId() throws ClassNotFoundException, SQLException{
        String sql = "select Detail_Code from Item_Detail order by 1 desc limit 1";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return IDGenerator.getNextId("D", rst.getString(1));
        }
        return IDGenerator.getNextId("D", null);
    }

    public static boolean addItemDetails(ArrayList<ItemDetail> itemDetailsList) throws ClassNotFoundException, SQLException {
        String sql = "insert into Item_Detail values(?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        
        int count = 0;
        for (ItemDetail detail : itemDetailsList) {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setObject(1, detail.getDetailCode());
            pstm.setObject(2, detail.getInvoiceNumber());
            pstm.setObject(3, detail.getItemCode());
            pstm.setObject(4, detail.getBuyingPrice());
            pstm.setObject(5, detail.getQtyOfEachItem());
            pstm.setObject(6, detail.getQtyOfEachItem() * detail.getBuyingPrice());
            pstm.setObject(7, detail.getSupplierCode());
            
            count += pstm.executeUpdate();
        }
        
        return count == itemDetailsList.size();
        
    }
}
