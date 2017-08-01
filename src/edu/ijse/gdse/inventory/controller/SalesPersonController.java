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
import edu.ijse.gdse.inventory.model.SalesPerson;

/**
 *
 * @author Pahansith
 */
public class SalesPersonController {

    public static boolean addSalesPerson(SalesPerson salesPerson) throws ClassNotFoundException, SQLException {
        String sql = "insert into Sales_Person values(?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, salesPerson.getNicOfSalesPerson());
        pstm.setObject(2, salesPerson.getName());
        pstm.setObject(3, salesPerson.getAddress());
        pstm.setObject(4, salesPerson.getDateOfBirth());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean updateSalesPerson(SalesPerson salesPerson) throws ClassNotFoundException, SQLException {
        String sql = "update Sales_Person set Name=?,Address=?,DOB=? where NIC =?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, salesPerson.getName());
        pstm.setObject(2, salesPerson.getAddress());
        pstm.setObject(3, salesPerson.getDateOfBirth());
        pstm.setObject(4, salesPerson.getNicOfSalesPerson());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean deleteSalesPerson(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Sales_Person where NIC='" + id + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;

    }

    public static SalesPerson searchSalesPerson(String salesPersonId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Sales_Person where NIC=? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, salesPersonId);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new SalesPerson(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));

        }
        return null;

    }

    public static ArrayList<SalesPerson> viewAllSalesPerson() throws ClassNotFoundException, SQLException {
        String sql = "select * from Sales_Person ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        ArrayList<SalesPerson> salesPersonList = new ArrayList<>();
        while (rst.next()) {
            SalesPerson salesPerson = new SalesPerson(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4));
            salesPersonList.add(salesPerson);
        }
        return salesPersonList;
    }
}
