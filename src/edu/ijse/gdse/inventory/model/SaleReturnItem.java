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
public class SaleReturnItem {
    private String saleId;
    private int quantity;
    private String returnDate;

    public SaleReturnItem() {
        
    }

    public SaleReturnItem(String saleId, int quantity, String returnDate) {
        this.saleId = saleId;
        this.quantity = quantity;
        this.returnDate = returnDate;
    }

    /**
     * @return the saleId
     */
    public String getSaleId() {
        return saleId;
    }

    /**
     * @param saleId the saleId to set
     */
    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
    
    
    
}
