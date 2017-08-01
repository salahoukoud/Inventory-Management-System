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
import edu.ijse.gdse.inventory.model.InventoryItem;
import edu.ijse.gdse.inventory.model.ItemDetail;
import edu.ijse.gdse.inventory.model.Payment;
import edu.ijse.gdse.inventory.model.PurchaseInvoice;
import edu.ijse.gdse.inventory.model.helper.UpdateInventoryItem;
import edu.ijse.gdse.inventory.other.IDGenerator;

/**
 *
 * @author Pahansith
 */
public class PurchaseInvoiceController {

    public static String getNextInvoiceNumber() throws ClassNotFoundException, SQLException {
        String sql = "select Invoice_No from Purchase_Invoice order by 1 desc limit 1";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return IDGenerator.getNextId("In", rst.getString(1));
        }
        return IDGenerator.getNextId("In", null);
    }

    public static boolean addNewPurchaseInvoice(PurchaseInvoice invoiceDetail,ArrayList<UpdateInventoryItem> updateList ,Payment payment, ArrayList<InventoryItem> newlyAddingItemsList, ArrayList<ItemDetail> itemDetailsList) throws ClassNotFoundException, SQLException {
        String sql = "insert into Purchase_Invoice values (?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        try {
            conn.setAutoCommit(false);
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setObject(1, invoiceDetail.getInvoiceNumber());
            pstm.setObject(2, invoiceDetail.getVendorId());
            pstm.setObject(3, invoiceDetail.getReceivedDate());
            pstm.setObject(4, invoiceDetail.getCreditPeriod());

            boolean isInvoiceAdded = pstm.executeUpdate() > 0;
            if (isInvoiceAdded) {
                boolean isPaymentAdded = PaymentController.addPayment(payment);
                if (isPaymentAdded) {
                    boolean isItemsAdded = InventoryItemController.addItems(newlyAddingItemsList);
                    boolean isQtyUpgraded = InventoryItemController.upgradeQty(updateList);
                    if (isQtyUpgraded || isItemsAdded) {
                        boolean isDetailsAdded = ItemDetailController.addItemDetails(itemDetailsList);
                        if (isDetailsAdded) {
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
            }
            conn.rollback();
            return false;

        } finally {
            conn.setAutoCommit(true);
        }

    }
}
