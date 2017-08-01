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

/**
 *
 * @author Pahansith
 */
public class BrandController {
    public static boolean addNewBrand(Brand brand) throws ClassNotFoundException, SQLException{
        String sql = "insert into Brand values (?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, brand.getBrandId());
        pstm.setObject(2, brand.getBrandName());
        return pstm.executeUpdate()>0;
    }
    public static boolean updateBrand(Brand brand) throws ClassNotFoundException, SQLException{
        String sql = "update Brand set Name = ? where BID = ?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, brand.getBrandName());
        pstm.setObject(2, brand.getBrandId());
        return pstm.executeUpdate()>0;
    }
    public static Brand searchBrand(String brandId) throws ClassNotFoundException, SQLException{
        String sql = "select * from Brand where BID = '"+brandId+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            Brand brand = new Brand();
            brand.setBrandId(brandId);
            brand.setBrandName(rst.getString(2));
            return brand;
        }
        return null;
    }
    
    public static boolean deleteBrand(String brandId) throws ClassNotFoundException, SQLException{
        String sql = "delete from Brand where BID = '"+brandId+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(sql)>0;
    }
    
    public static ArrayList<Brand> viewAllBrands() throws ClassNotFoundException, SQLException{
        String sql = "select * from Brand";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Brand> brandList = new ArrayList<>();
        while(rst.next()){
            Brand brand = new Brand();
            brand.setBrandId(rst.getString(1));
            brand.setBrandName(rst.getString(2));
            brandList.add(brand);
        }
        return brandList;
    }
}
