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
import edu.ijse.gdse.inventory.model.ItemSubType;

/**
 *
 * @author Pahansith
 */
public class ItemSubTypeDetailController {
    public static ArrayList<ItemSubType> getItemSubTypes(String productCode) throws ClassNotFoundException, SQLException{
        String sql = "select t.SID,Name from Item_Sub_Type_Detail d , Item_Sub_Type t where d.SID = t.SID and Product_Code = '"+productCode+"'";
        
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<ItemSubType> subTypeList = new ArrayList<>();
        while(rst.next()){
            ItemSubType subType = new ItemSubType(rst.getString(1), rst.getString(2));
            subTypeList.add(subType);
        }
        
        return subTypeList;
    }
}
