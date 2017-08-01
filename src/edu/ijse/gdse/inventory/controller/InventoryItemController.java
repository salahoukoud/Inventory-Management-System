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
import edu.ijse.gdse.inventory.model.InventoryItem;
import edu.ijse.gdse.inventory.model.ItemDetail;
import edu.ijse.gdse.inventory.model.SaleItem;
import edu.ijse.gdse.inventory.model.helper.SellInventoryItem;
import edu.ijse.gdse.inventory.model.helper.UpdateInventoryItem;
import edu.ijse.gdse.inventory.other.IDGenerator;

/**
 *
 * @author Pahansith
 */
public class InventoryItemController {
    public static boolean addNewItem(InventoryItem inventoryItem) throws ClassNotFoundException, SQLException{
        String sql = "insert into inventory_item values (?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, inventoryItem.getItemCode());
        pstm.setObject(2, inventoryItem.getProductCode());
        pstm.setObject(3, inventoryItem.getSupplyPrice());
        
        pstm.setObject(4, inventoryItem.getMarkup());
        pstm.setObject(5, inventoryItem.getRetailPrice());
        pstm.setObject(6, inventoryItem.getQtyOnHand());
        pstm.setObject(7, inventoryItem.getMinimumQty());
        pstm.setObject(8, inventoryItem.getDiscountOfItem());
        pstm.setObject(9, inventoryItem.isReturnStatus());
        pstm.setObject(10, inventoryItem.getItemSize());
        pstm.setObject(11, inventoryItem.getAddedDate());
        pstm.setObject(13, inventoryItem.getBrandName());
        
        return pstm.executeUpdate() > 0;
    }
    
    public static InventoryItem searchItem(String id) throws ClassNotFoundException, SQLException{
        String sql = "select * from Inventory_Item where Item_Code = '"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            InventoryItem item = new InventoryItem();
            item.setItemCode(rst.getString(1));
            item.setProductCode(rst.getString(2));
            item.setSupplyPrice(rst.getDouble(3));
            item.setMarkup(rst.getDouble(4));
            item.setRetailPrice(rst.getDouble(5));
            item.setQtyOnHand(rst.getInt(6));
            item.setMinimumQty(rst.getInt(7));
            item.setDiscountOfItem(rst.getDouble(8));
            item.setReturnStatus(rst.getBoolean(9));
            item.setItemSize(rst.getString(10));
            item.setAddedDate(rst.getString(11));
            item.setBrandName(rst.getString(12));
            item.setGender(rst.getString(13));
            return item;
        }
        return null;
    }
    
    public static boolean deleteItem(String id) throws ClassNotFoundException, SQLException{
        String sql = "delete from Inventory_Item where Item_Code = '"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(sql) > 0;
    }
    
    public static boolean updateItem(InventoryItem inventoryItem) throws ClassNotFoundException, SQLException{
        String sql = "update Vendor set Product_Code =?,Supply_Price =?,Markup =?,"
                + "Qty_On_Hand = ?,Minimum_Qty = ?,Discount_Of_Item = ?,Return_Status =?,Size_Of_Item =?, Added_Date =?  "
                + "where Item_Code = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, inventoryItem.getProductCode());
        pstm.setObject(2, inventoryItem.getSupplyPrice());
        pstm.setObject(3, inventoryItem.getMarkup());
        pstm.setObject(4, inventoryItem.getQtyOnHand());
        pstm.setObject(5, inventoryItem.getMinimumQty());
        pstm.setObject(6, inventoryItem.getDiscountOfItem());
        pstm.setObject(7, inventoryItem.isReturnStatus());
        pstm.setObject(8, inventoryItem.getItemSize());
        pstm.setObject(9, inventoryItem.getAddedDate());
        pstm.setObject(10, inventoryItem.getItemCode());
        
        return pstm.executeUpdate() > 0;
    }
    
    public static ArrayList<InventoryItem> viewAllItem() throws ClassNotFoundException, SQLException{
        String sql = "select * from Vendor";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        
        ArrayList<InventoryItem> itemList = new ArrayList<>();
        while(rst.next()){
            InventoryItem item = new InventoryItem();
            item.setItemCode(rst.getString(1));
            item.setProductCode(rst.getString(2));
            item.setSupplyPrice(rst.getDouble(3));
            item.setMarkup(rst.getDouble(4));
            item.setRetailPrice(rst.getDouble(5));
            item.setQtyOnHand(rst.getInt(6));
            item.setMinimumQty(rst.getInt(7));
            item.setDiscountOfItem(rst.getDouble(8));
            item.setReturnStatus(rst.getBoolean(9));
            item.setItemSize(rst.getString(10));
            item.setAddedDate(rst.getString(11));
            item.setBrandName(rst.getString(12));
        }
        return itemList;
    }
    
    public static SellInventoryItem getDetailsForSale(String itemCode) throws ClassNotFoundException, SQLException{
        String sql = "select Product_Name,Description,Retail_Price,Discount_Of_Item,Brand From Inventory_Item natural join Item_Major where Item_Code = '"+itemCode+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery(sql);
        
        if(rst.next()){
            SellInventoryItem itemSell = new SellInventoryItem();
            itemSell.setProductName(rst.getString(1));
            itemSell.setDescription(rst.getString(2));
            itemSell.setRetailPrice(rst.getDouble(3));
            itemSell.setDiscount(rst.getDouble(4));
            itemSell.setBrand(rst.getString(5));
            return itemSell;
        }
        return null;
    }
    
    public static boolean updateQty(ArrayList<SaleItem> itemList) throws ClassNotFoundException, SQLException{
        String sql = "update Inventory_Item set Qty_On_Hand = Qty_On_Hand - ? where Item_Code = ?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        int count = 0;
        for (SaleItem item : itemList) {
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setObject(1, item.getSoldQuantity());
            pstm.setObject(2, item.getItemCode());
            count += pstm.executeUpdate();
        }
        return count == itemList.size();
    }

    public static boolean upgradeQty(ArrayList<UpdateInventoryItem> updateList) throws ClassNotFoundException, SQLException {
        String sql = "update Inventory_Item set Qty_On_Hand = Qty_On_Hand + ? where Item_Code = ?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        int count =0;
        if (!updateList.isEmpty()) {
            for (UpdateInventoryItem detail : updateList) {
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setObject(1, detail.getUpdateQty());
                pstm.setObject(2, detail.getItemCode());
                
                count += pstm.executeUpdate();
            }
            
            return count == updateList.size();
        }
        return true;
    }

    public static boolean addItems(ArrayList<InventoryItem> newlyAddingItemsList) throws ClassNotFoundException, SQLException {
        if (!newlyAddingItemsList.isEmpty()) {
            String sql = "insert into inventory_item values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection conn = DBConnection.getDBConnection().getConnection();
            int count = 0;
            for (InventoryItem inventoryItem : newlyAddingItemsList) {
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setObject(1, inventoryItem.getItemCode());
                pstm.setObject(2, inventoryItem.getProductCode());
                pstm.setObject(3, inventoryItem.getSupplyPrice());
                pstm.setObject(4, inventoryItem.getMarkup());
                pstm.setObject(5, inventoryItem.getRetailPrice());
                pstm.setObject(6, inventoryItem.getQtyOnHand());
                pstm.setObject(7, inventoryItem.getMinimumQty());
                pstm.setObject(8, inventoryItem.getDiscountOfItem());
                pstm.setObject(9, inventoryItem.isReturnStatus());
                pstm.setObject(10, inventoryItem.getItemSize());
                pstm.setObject(11, inventoryItem.getAddedDate());
                pstm.setObject(12, inventoryItem.getBrandName());
                pstm.setObject(13, inventoryItem.getGender());
                count += pstm.executeUpdate();
            }
            return count == newlyAddingItemsList.size();
        }else{
            return true;
        }
    }
    
    public static String getNextItemCode() throws ClassNotFoundException, SQLException{
        String sql = "Select Item_Code from Inventory_Item order by 1 desc limit 1";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return IDGenerator.getNextId("I", rst.getString(1));
        }
        return IDGenerator.getNextId("I", null);
    }
    
    public static int getCountOfReOrderClosingItems() throws SQLException, ClassNotFoundException{
        String sql = "select count(Item_Code) from Inventory_Item where (Qty_On_Hand - Minimum_Qty) <= 20";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt(1);
        }
        return -1;
        
    }
    
    public static int getInventoryCount() throws ClassNotFoundException, SQLException{
        String sql = "select count(Item_Code) from Inventory_Item";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt(1);
        }
        return -1;
    }
    
    public static double getInventoryValue() throws ClassNotFoundException, SQLException{
        String sql = "select sum(Retail_Price*Qty_On_Hand) from Inventory_Item";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return rst.getDouble(1);
        }
        
        return -1;
    }
}
