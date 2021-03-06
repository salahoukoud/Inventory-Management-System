/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse.inventory.view.forms;

import edu.ijse.gdse.inventory.controller.VendorController;
import edu.ijse.gdse.inventory.db.DBConnection;
import edu.ijse.gdse.inventory.model.Vendor;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Pahansith
 */
public class ProductByVendorForm extends javax.swing.JPanel {

    private JasperPrint filledDailySalesReport;

    /**
     * Creates new form SalesReportForm
     */
    public ProductByVendorForm() {
        initComponents();
        loadVendorCombo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reportHostPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameCombo = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1120, 560));
        setLayout(null);

        reportHostPanel.setBackground(new java.awt.Color(255, 255, 255));
        reportHostPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(43, 87, 154)));
        reportHostPanel.setLayout(null);
        add(reportHostPanel);
        reportHostPanel.setBounds(450, 0, 660, 550);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(43, 87, 154)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Vendor Name");

        nameCombo.setBackground(new java.awt.Color(0, 204, 204));
        nameCombo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nameCombo.setForeground(new java.awt.Color(43, 87, 154));

        jButton2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton2.setText("View");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("   Select Vendor");
        jLabel10.setMinimumSize(new java.awt.Dimension(68, 22));
        jLabel10.setOpaque(true);
        jLabel10.setPreferredSize(new java.awt.Dimension(68, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameCombo, 0, 328, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        add(jPanel1);
        jPanel1.setBounds(20, 20, 350, 400);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            try {
                
                
                Connection conn = DBConnection.getDBConnection().getConnection();
                InputStream file = getClass().getResourceAsStream("/edu/ijse/gdse/inventory/jasperreports/TotalStockItemReport.jrxml");
                try {
                    JasperReport compiledReport = JasperCompileManager.compileReport(file);
                    filledDailySalesReport = JasperFillManager.fillReport(compiledReport, new HashMap<>(),conn);
                    JRViewer jrViewer = new JRViewer(filledDailySalesReport);
                    jrViewer.setBounds(0, 0, reportHostPanel.getWidth(), reportHostPanel.getHeight());
                    reportHostPanel.add(jrViewer);
                    reportHostPanel.repaint();
                    reportHostPanel.revalidate();
                } catch (JRException ex) {
                    Logger.getLogger(ProductByVendorForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProductByVendorForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
            Logger.getLogger(ProductByVendorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> nameCombo;
    private javax.swing.JPanel reportHostPanel;
    // End of variables declaration//GEN-END:variables

    private String getDate() {
        Date date = new Date();
        SimpleDateFormat instance = new SimpleDateFormat("yyyy-MM-dd");
        return instance.format(date);
        
    }

    private void loadVendorCombo() {
        try {
            ArrayList<Vendor> vendors = VendorController.viewAllVendors();
            DefaultComboBoxModel model = (DefaultComboBoxModel) nameCombo.getModel();
            vendors.stream().forEach((selectedVendor) -> {
                model.addElement(selectedVendor);
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductByVendorForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProductByVendorForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
