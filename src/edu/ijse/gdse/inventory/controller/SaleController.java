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
import edu.ijse.gdse.inventory.model.Sale;
import edu.ijse.gdse.inventory.model.SaleItem;
import edu.ijse.gdse.inventory.other.IDGenerator;

/**
 *
 * @author Pahansith
 */
public class SaleController {

    public static String getNextBillNumber() throws ClassNotFoundException, SQLException {
        String sql = "select Bill_No from sale order by 1 desc limit 1";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery(sql);
        if (rst.next()) {
            String id = rst.getString("Bill_No");
            return IDGenerator.getNextId("BN", id);
        }
        return IDGenerator.getNextId("BN", null);

    }

    public static boolean newSale(Sale sale, ArrayList<SaleItem> saleItemList) throws ClassNotFoundException, SQLException {
        String sql = "insert into Sale values (?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setObject(1, sale.getBillNumber());
        pst.setObject(2, sale.getNicOfSalesPerson());
        pst.setObject(3, sale.getBillDate());
        pst.setObject(4, sale.getDiscount());
        pst.setObject(5, sale.getTotalAmount());
        pst.setObject(6, sale.getRecievedCash());
        pst.setObject(7, sale.getBalance());
        pst.setObject(8, sale.getTax());
        conn.setAutoCommit(false);

        try {
            boolean isAdded = pst.executeUpdate() > 0;
            if (isAdded) {
                boolean isAddAll = SaleItemController.addSaleItems(saleItemList);
                if (isAddAll) {
                    boolean updateAllItem = InventoryItemController.updateQty(saleItemList);
                    if (updateAllItem) {
                        conn.commit();
                        return true;
                    }
                    conn.rollback();
                    return false;
                }
                conn.rollback();
                return false;
            }
            conn.rollback();
            return false;
        } finally {
            conn.setAutoCommit(true);
        }
    }

    public static boolean updateSale(Sale sale) throws ClassNotFoundException, SQLException {
        String sql = "update Sale set NIC=?,Bill_Date =?,Total_Discount=?,Total_Amount=?,Received_Cash=?,Balance_Amount=?,Tax=? where Bill_No=?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, sale.getNicOfSalesPerson());
        pstm.setObject(2, sale.getBillDate());
        pstm.setObject(3, sale.getDiscount());
        pstm.setObject(4, sale.getTotalAmount());
        pstm.setObject(5, sale.getRecievedCash());
        pstm.setObject(6, sale.getBalance());
        pstm.setObject(7, sale.getTax());
        pstm.setObject(8, sale.getBillNumber());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean deleteSale(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Sale where Bill_No='" + id + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;

    }

    public static Sale searchSale(String saleId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Sale where Bill_No =? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, saleId);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new Sale(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getDouble(5), rst.getDouble(6), rst.getDouble(7), rst.getDouble(8));

        }
        return null;

    }

    public static ArrayList<Sale> viewAllSaleDetails() throws ClassNotFoundException, SQLException {
        String sql = "select * from Sale ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        ArrayList<Sale> saleDetailList = new ArrayList<>();
        while (rst.next()) {
            Sale sale = new Sale(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getDouble(5), rst.getDouble(6), rst.getDouble(7), rst.getDouble(8));
            saleDetailList.add(sale);
        }
        return saleDetailList;
    }
}
