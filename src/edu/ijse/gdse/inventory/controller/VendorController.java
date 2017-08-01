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
import edu.ijse.gdse.inventory.model.Vendor;
import edu.ijse.gdse.inventory.other.IDGenerator;

/**
 *
 * @author Pahansith
 */
public class VendorController {
    public static boolean addNewVendor(Vendor vendor) throws ClassNotFoundException, SQLException{
        String sql = "insert into vendor values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, vendor.getVendorId());
        pstm.setObject(2, vendor.getTermId());
        pstm.setObject(3, vendor.getName());
        pstm.setObject(4, vendor.getTaxId());
        pstm.setObject(5, vendor.getAddress());
        pstm.setObject(6, vendor.getTelephoneNumber());
        pstm.setObject(7, vendor.getMobileNumber());
        pstm.setObject(8, vendor.getCreditLimit());
        pstm.setObject(9, vendor.getEmailAddress());
        pstm.setObject(10, vendor.getFax());
        pstm.setObject(11, vendor.getWebSite());
        pstm.setObject(12, vendor.isTaxStatus());
        pstm.setObject(13, vendor.getCompany());
        
        return pstm.executeUpdate() > 0;
    }
    
    public static Vendor searchVendor(String id) throws ClassNotFoundException, SQLException{
        String sql = "select * from Vendor where VID = '"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Vendor vendor = new Vendor();
            vendor.setVendorId(rst.getString(1));
            vendor.setTermId(rst.getString(2));
            vendor.setName(rst.getString(3));
            vendor.setTaxId(rst.getString(4));
            vendor.setAddress(rst.getString(5));
            vendor.setTelephoneNumber(rst.getInt(6));
            vendor.setMobileNumber(rst.getInt(7));
            vendor.setCreditLimit(rst.getDouble(8));
            vendor.setEmailAddress(rst.getString(9));
            vendor.setFax(rst.getInt(10));
            vendor.setWebSite(rst.getString(11));
            vendor.setTaxStatus(rst.getBoolean(12));
            vendor.setCompany(rst.getString(13));
            
            return vendor;
        }
        return null;
    }
    
    public static boolean deleteVendor(String id) throws ClassNotFoundException, SQLException{
        String sql = "delete from Vendor where VID = '"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(sql) > 0;
    }
    
    public static boolean updateVendor(Vendor vendor) throws ClassNotFoundException, SQLException{
        String sql = "update Vendor set Term_ID =?, Name = ?,TID = ?, Address = ?, Telephone_number = ?,Mobile_Number = ?,"
                + " Credit_Limit = ?,Email_Address = ?,Fax = ?,Web = ?, Tax_Status = ?,Company = ? "
                + "where VID = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, vendor.getTermId());
        pstm.setObject(2, vendor.getName());
        pstm.setObject(3, vendor.getTaxId());
        pstm.setObject(4, vendor.getAddress());
        pstm.setObject(5, vendor.getTelephoneNumber());
        pstm.setObject(6, vendor.getMobileNumber());
        pstm.setObject(7, vendor.getCreditLimit());
        pstm.setObject(8, vendor.getEmailAddress());
        pstm.setObject(9, vendor.getFax());
        pstm.setObject(10, vendor.getWebSite());
        pstm.setObject(11, vendor.isTaxStatus());
        pstm.setObject(12, vendor.getCompany());
        pstm.setObject(13, vendor.getVendorId());
        return pstm.executeUpdate() > 0;
    }
   
    
    public static String getNextVendorId() throws ClassNotFoundException, SQLException{
        String sql = "select VID from Vendor order by 1 desc limit 1";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return IDGenerator.getNextId("V", rst.getString(1));
        }
        return IDGenerator.getNextId("V", null);
    }
    
    public static ArrayList<Vendor> viewAllVendors() throws ClassNotFoundException, SQLException{
        String sql = "select * from Vendor";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Vendor> vendorList = new ArrayList<>();
        while(rst.next()){
            Vendor vendor = new Vendor();
            vendor.setVendorId(rst.getString(1));
            vendor.setTermId(rst.getString(2));
            vendor.setName(rst.getString(3));
            vendor.setTaxId(rst.getString(4));
            vendor.setAddress(rst.getString(5));
            vendor.setTelephoneNumber(rst.getInt(6));
            vendor.setMobileNumber(rst.getInt(7));
            vendor.setCreditLimit(rst.getDouble(8));
            vendor.setEmailAddress(rst.getString(9));
            vendor.setFax(rst.getInt(10));
            vendor.setWebSite(rst.getString(11));
            vendor.setTaxStatus(rst.getBoolean(12));
            vendor.setCompany(rst.getString(13));
            
            vendorList.add(vendor);
        }
        return vendorList;
    }
    
    public static ArrayList<String> getVendorNames() throws ClassNotFoundException, SQLException{
        String sql = "select VID,Name from Vendor";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> nameList = new ArrayList<>();
        while(rst.next()){
            String vid = rst.getString(1);
            String name = rst.getString(2);
            
            String value = name+" - "+vid;
            nameList.add(value);
        }
        return nameList;
        
    }
    
    public static ArrayList<String> getAllVendorIdName() throws ClassNotFoundException, SQLException{
        String sql = "select VID, Name from Vendor";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<String> list = new ArrayList<>();
        while(rst.next()){
            String id = rst.getString(1);
            String name = rst.getString(2);
            
            list.add(name+" - "+id);
        }
        return list;
    }
}
