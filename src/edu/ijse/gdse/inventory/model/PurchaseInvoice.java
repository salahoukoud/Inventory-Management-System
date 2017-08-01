/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse.inventory.model;

/**
 *
 * @author Pahansith
 */
public class PurchaseInvoice {
    private String invoiceNumber;
    private String vendorId;
    private String receivedDate;
    private int creditPeriod;

    public PurchaseInvoice() {
    }

    public PurchaseInvoice(String invoiceNumber, String vendorId, String receivedDate, int creditPeriod) {
        this.invoiceNumber = invoiceNumber;
        this.vendorId = vendorId;
        this.receivedDate = receivedDate;
        this.creditPeriod = creditPeriod;
    }

    /**
     * @return the invoiceNumber
     */
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    /**
     * @param invoiceNumber the invoiceNumber to set
     */
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    /**
     * @return the vendorId
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     * @param vendorId the vendorId to set
     */
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * @return the receivedDate
     */
    public String getReceivedDate() {
        return receivedDate;
    }

    /**
     * @param receivedDate the receivedDate to set
     */
    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    /**
     * @return the creditPeriod
     */
    public int getCreditPeriod() {
        return creditPeriod;
    }

    /**
     * @param creditPeriod the creditPeriod to set
     */
    public void setCreditPeriod(int creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    
}
