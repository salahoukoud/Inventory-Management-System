/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse.inventory.controller;

import edu.ijse.gdse.inventory.db.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import edu.ijse.gdse.inventory.model.Brand;

/**
 *
 * @author Pahansith
 */
public class BrandDetailController {
    public static ArrayList<Brand> getSelectedBrands(String productCode) throws ClassNotFoundException, SQLException{
        String sql = "select b.BID,Name from Brand b , Brand_Detail d where d.BID = b.BID and Product_Code = '"+productCode+"'";
        
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<Brand> brandList = new ArrayList<>();
        while(rst.next()){
            Brand brand = new Brand(rst.getString(1), rst.getString(2));
            brandList.add(brand);
        }
        
        return brandList;
    }
    
    
}
