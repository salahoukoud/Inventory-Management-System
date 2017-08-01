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
public class SaleItem {
    private String saleId;
    private String itemCode;
    private String billNumber;
    private double totalAmount;
    private double labeledPrice;
    private double soldPrice;
    private int soldQuantity;
    private double discount;

    public SaleItem() {
    }

    public SaleItem(String saleId, String itemCode, String billNumber, double totalAmount, double labeledPrice, double soldPrice, int soldQuantity, double discount) {
        this.saleId = saleId;
        this.itemCode = itemCode;
        this.billNumber = billNumber;
        this.totalAmount = totalAmount;
        this.labeledPrice = labeledPrice;
        this.soldPrice = soldPrice;
        this.soldQuantity = soldQuantity;
        this.discount = discount;
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
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the billNumber
     */
    public String getBillNumber() {
        return billNumber;
    }

    /**
     * @param billNumber the billNumber to set
     */
    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    /**
     * @return the totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the labeledPrice
     */
    public double getLabeledPrice() {
        return labeledPrice;
    }

    /**
     * @param labeledPrice the labeledPrice to set
     */
    public void setLabeledPrice(double labeledPrice) {
        this.labeledPrice = labeledPrice;
    }

    /**
     * @return the soldPrice
     */
    public double getSoldPrice() {
        return soldPrice;
    }

    /**
     * @param soldPrice the soldPrice to set
     */
    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    /**
     * @return the soldQuantity
     */
    public int getSoldQuantity() {
        return soldQuantity;
    }

    /**
     * @param soldQuantity the soldQuantity to set
     */
    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    
    
    
    
}
