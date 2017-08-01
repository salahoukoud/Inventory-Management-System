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
import edu.ijse.gdse.inventory.model.ItemMajor;
import edu.ijse.gdse.inventory.other.IDGenerator;

/**
 *
 * @author Pahansith
 */
public class ItemMajorController {

    public static boolean addNewItemMajor(ItemMajor itemMajor) throws ClassNotFoundException, SQLException {
        String sql = "insert into Item_Major values(?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, itemMajor.getProductCode());
        pstm.setObject(2, itemMajor.getTypeId());
        pstm.setObject(3, itemMajor.getProductName());
        pstm.setObject(4, itemMajor.getDescription());
        return pstm.executeUpdate() > 0;
    }

    public static boolean updateItemMajor(ItemMajor itemMajor) throws ClassNotFoundException, SQLException {
        String sql = "update Item_Major set Product_Name = ?,Type_Id = ?,Description = ?, where Product_Code = ?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, itemMajor.getProductName());
        pstm.setObject(2, itemMajor.getTypeId());
        pstm.setObject(3, itemMajor.getDescription());
        pstm.setObject(4, itemMajor.getProductCode());
        return pstm.executeUpdate() > 0;
    }

    public static ItemMajor searchItemMajor(String prodctCode) throws ClassNotFoundException, SQLException {
        String sql = "select * from Item_Major where Product_Code = '" + prodctCode + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            ItemMajor itemMajor = new ItemMajor();
            itemMajor.setProductCode(prodctCode);
            itemMajor.setTypeId(rst.getString(2));
            itemMajor.setProductName(rst.getString(3));
            itemMajor.setDescription(rst.getString(4));
            return itemMajor;
        }
        return null;
    }

    public static ArrayList<ItemMajor> getAllItemMajorDetail() throws ClassNotFoundException, SQLException {
        String sql = "select * from Item_Major";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ItemMajor> itemMajorDetails = new ArrayList<>();
        while (rst.next()) {

            ItemMajor itemMajor = new ItemMajor();
            itemMajor.setProductCode(rst.getString(1));
            itemMajor.setTypeId(rst.getString(2));
            itemMajor.setProductName(rst.getString(3));
            itemMajor.setDescription(rst.getString(4));
            itemMajorDetails.add(itemMajor);
        }
        return itemMajorDetails;
    }

    public static boolean deleteItemMajor(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Item_Major where Product_Code='" + id + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;

    }

    public static ArrayList<ItemMajor> viewAllItemMajorDetails() throws ClassNotFoundException, SQLException {
        String sql = "select * from Item_Major ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        ArrayList<ItemMajor> itemMajorList = new ArrayList<>();
        while (rst.next()) {
            ItemMajor itemMajor = new ItemMajor(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
            itemMajorList.add(itemMajor);
        }
        return itemMajorList;
    }
    
    public static ArrayList<ItemMajor> getItemMajor(String typeId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Item_Major where Type_Id = '" + typeId + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ItemMajor> majorList = new ArrayList<>();
        while (rst.next()) {
            ItemMajor itemMajor = new ItemMajor();
            itemMajor.setProductCode(rst.getString(1));
            itemMajor.setTypeId(rst.getString(2));
            itemMajor.setProductName(rst.getString(3));
            itemMajor.setDescription(rst.getString(4));
            majorList.add(itemMajor);
        }
        return majorList;
    }
    
    public static String getNextItemMajorId() throws ClassNotFoundException, SQLException{
        String sql = "select Product_Code from Item_Major order by 1 desc limit 1";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        
        if (rst.next()) {
            return IDGenerator.getItemMajorId("P", rst.getString(1));
        }
        return IDGenerator.getItemMajorId("P", null);
    }

}
