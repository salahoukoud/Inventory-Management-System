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
public class PurchaseReturnItem {
    private String detailCode;
    private String dateOfReturn;
    private String description;
    private int returnQty;

    public PurchaseReturnItem() {
    }

    public PurchaseReturnItem(String detailCode, String dateOfReturn, String description, int returnQty) {
        this.detailCode = detailCode;
        this.dateOfReturn = dateOfReturn;
        this.description = description;
        this.returnQty = returnQty;
    }

    /**
     * @return the detailCode
     */
    public String getDetailCode() {
        return detailCode;
    }

    /**
     * @param detailCode the detailCode to set
     */
    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode;
    }

    /**
     * @return the dateOfReturn
     */
    public String getDateOfReturn() {
        return dateOfReturn;
    }

    /**
     * @param dateOfReturn the dateOfReturn to set
     */
    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the returnQty
     */
    public int getReturnQty() {
        return returnQty;
    }

    /**
     * @param returnQty the returnQty to set
     */
    public void setReturnQty(int returnQty) {
        this.returnQty = returnQty;
    }
    
    
}
