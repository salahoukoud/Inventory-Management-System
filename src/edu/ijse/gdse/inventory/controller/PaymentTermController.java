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
import edu.ijse.gdse.inventory.model.PaymentTerm;

/**
 *
 * @author Pahansith
 */
public class PaymentTermController {

    public static ArrayList<PaymentTerm> getAllPayementTerms() throws ClassNotFoundException, SQLException {
        String sql = "select * from Payment_Term";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        ArrayList<PaymentTerm> termList = new ArrayList<>();
        while (rst.next()) {
            PaymentTerm term = new PaymentTerm();
            term.setTermId(rst.getString(1));
            term.setTermCategory(rst.getString(2));
            term.setDuration(rst.getInt(3));
            termList.add(term);
        }
        return termList;
    }

    public static boolean addPaymentTerm(PaymentTerm paymentTerm) throws ClassNotFoundException, SQLException {
        String sql = "insert into Payment_Term values(?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, paymentTerm.getTermId());
        pstm.setObject(2, paymentTerm.getTermCategory());
        pstm.setObject(3, paymentTerm.getDuration());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean updatePaymentTerm(PaymentTerm paymentTerm) throws ClassNotFoundException, SQLException {
        String sql = "update Payment_Term set Term_Category=?,Duration=? where Term_ID =?";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, paymentTerm.getTermCategory());
        pstm.setObject(2, paymentTerm.getDuration());
        pstm.setObject(3, paymentTerm.getTermId());
        int res = pstm.executeUpdate();
        return res > 0;

    }

    public static boolean deletePaymentTerm(String id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Payment_Term where Term_ID='" + id + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res > 0;

    }

    public static PaymentTerm searchPaymentTerm(String paymentTermId) throws ClassNotFoundException, SQLException {
        String sql = "select * from Payment_Term where Term_ID =? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setObject(1, paymentTermId);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new PaymentTerm(rst.getString(1), rst.getString(2), rst.getInt(3));

        }
        return null;

    }
}
