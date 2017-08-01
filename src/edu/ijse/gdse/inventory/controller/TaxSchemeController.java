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
import edu.ijse.gdse.inventory.model.TaxScheme;
import edu.ijse.gdse.inventory.other.IDGenerator;

/**
 *
 * @author Pahansith
 */
public class TaxSchemeController {
    public static ArrayList<TaxScheme> getAllTaxScehemes() throws SQLException, ClassNotFoundException{
        String sql = "select * from Tax_Scheme";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<TaxScheme> taxSchemeList = new ArrayList<>();
        while(rst.next()){
            TaxScheme scheme = new TaxScheme();
            scheme.setTaxId(rst.getString(1));
            scheme.setTaxCategory(rst.getString(2));
            scheme.setTaxRate(rst.getDouble(3));
            taxSchemeList.add(scheme);
        }
        return taxSchemeList;
        
    }
    
    public static String getNextTaxId() throws ClassNotFoundException, SQLException{
        String sql = "select TID from Tax_Scheme order by 1 desc limit 1";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return IDGenerator.getNextId("T", rst.getString(1));
        }
        return IDGenerator.getNextId("I", null);
    }
    
    public static boolean addNewTaxScheme(TaxScheme scheme) throws ClassNotFoundException, SQLException{
        String sql = "insert into Tax_Scheme values(?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, scheme.getTaxId());
        pstm.setObject(2, scheme.getTaxCategory());
        pstm.setObject(3, scheme.getTaxRate());
        return pstm.executeUpdate()>0;
    }
    
    public static boolean updateTaxScheme(TaxScheme scheme) throws ClassNotFoundException, SQLException{
        String sql = "update Tax_Scheme set Tax_Category = ?, Tax_Rate = ? where TID = ?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, scheme.getTaxCategory());
        pstm.setObject(2, scheme.getTaxRate());
        pstm.setObject(3, scheme.getTaxId());
        return pstm.executeUpdate()>0;
    }
    
    public static boolean deleteTaxScheme(String id) throws ClassNotFoundException, SQLException{
        String sql = "delete from Tax_Scheme where TID = '"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(sql)>0;
    }
}
