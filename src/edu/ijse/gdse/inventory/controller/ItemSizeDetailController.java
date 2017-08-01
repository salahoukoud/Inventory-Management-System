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
import edu.ijse.gdse.inventory.model.Brand;
import edu.ijse.gdse.inventory.model.ItemSizeDetail;
import edu.ijse.gdse.inventory.model.SizeOfItem;

/**
 *
 * @author Pahansith
 */
public class ItemSizeDetailController {

    public static boolean addItemSizeDetail(ItemSizeDetail itemSizeDetail) throws ClassNotFoundException, SQLException {
        String sql = "insert into Item_Size_Detail values(?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, itemSizeDetail.getSizeId());
        pstm.setObject(2, itemSizeDetail.getProductCode());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean updateItemSizeDetail(ItemSizeDetail itemSizeDetail) throws ClassNotFoundException, SQLException {
        String sql = "update Item_Size_Detail set Product_Code=? where Size_ID =?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, itemSizeDetail.getProductCode());
        pstm.setObject(2, itemSizeDetail.getSizeId());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static ItemSizeDetail searchItemSizeDetail(String itemSizeId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Item_Size_Detail where Size_ID =? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, itemSizeId);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new ItemSizeDetail(rst.getString(1), rst.getString(2));

        }
        return null;

    }
    
    public static  ArrayList<SizeOfItem> getSelectedSizes(String productCode) throws ClassNotFoundException, SQLException{
        String sql = "select s.Size_Id ,Item_Size from Item_Size_Detail d , Size_Of_Item s where d.Size_Id = s.Size_Id and Product_Code = '"+productCode+"'";
        
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<SizeOfItem> sizeList = new ArrayList<>();
        while(rst.next()){
            SizeOfItem sizeOfItem = new SizeOfItem(rst.getString(1), rst.getString(2));
            sizeList.add(sizeOfItem);
        }
        
        return sizeList;
    }
}
