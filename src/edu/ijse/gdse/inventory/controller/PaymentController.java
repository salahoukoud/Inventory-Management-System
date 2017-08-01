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
import edu.ijse.gdse.inventory.model.Payment;
import edu.ijse.gdse.inventory.other.IDGenerator;

/**
 *
 * @author Pahansith
 */
public class PaymentController {

    public static boolean addPayment(Payment payment) throws ClassNotFoundException, SQLException {
        String sql = "insert into Payment values(?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, payment.getPaymentId());
        pstm.setObject(2, payment.getInvoiceNumber());
        pstm.setObject(3, payment.getDueDate());
        pstm.setObject(4, payment.getDiscount());
        pstm.setObject(5, payment.getTotalAmount());
        pstm.setObject(6, payment.isStatus());
        pstm.setObject(7, payment.getTotalAmount()- payment.getDiscount());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean updatePayment(Payment payment) throws ClassNotFoundException, SQLException {
        String sql = "update Payment set Invoice_No=?,Due_Date=?,Total_Amount=?,Discount = ?Status=? where PID =?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, payment.getInvoiceNumber());
        pstm.setObject(2, payment.getDueDate());
        pstm.setObject(3, payment.getTotalAmount());
        pstm.setObject(4, payment.getDiscount());
        pstm.setObject(5, payment.isStatus());
        pstm.setObject(6, payment.getPaymentId());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean deletePayment(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Payment where PID ='" + id + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;

    }
    
    public static boolean getNextPayment(String PID) throws ClassNotFoundException, SQLException{
        String sql = "SELECT PID,Discount,TotalAmount FROM Payment WHERE PID = '"+PID+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        return stm.executeUpdate(sql)>0;
    }
    
    public static Payment searchPayment(String paymentId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Payment where PID =? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, paymentId);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new Payment(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getDouble(5),rst.getBoolean(6),rst.getDouble(7));

        }
        return null;

    }

    public static ArrayList<Payment> viewAllPaymentDetails() throws ClassNotFoundException, SQLException {
        String sql = "select * from Payment";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rst = pstm.executeQuery();
        ArrayList<Payment> paymentDetailList = new ArrayList<>();
        while (rst.next()) {
            Payment payment = new Payment(rst.getString(1), rst.getString(2), rst.getString(3), rst.getDouble(4), rst.getDouble(5),rst.getBoolean(6),rst.getDouble(7));
            paymentDetailList.add(payment);
        }
        return paymentDetailList;
    }
    
    public static String getNextPaymentId() throws ClassNotFoundException, SQLException{
        String sql = "select PID from payment order by 1 desc limit 1";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        
        if (rst.next()) {
            return IDGenerator.getNextId("P", rst.getString(1));
        }
        return IDGenerator.getNextId("P", null);
    }
    
    public static int countOfUnpaidInvoices() throws ClassNotFoundException, SQLException{
        String sql = "select count(PID) from Payment where status = false";
        Connection con = DBConnection.getDBConnection().getConnection();
        Statement stm = con.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if(rst.next()){
            return rst.getInt(1);
        }
        return -1;
    }
}
