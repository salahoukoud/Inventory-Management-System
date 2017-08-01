/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse.inventory.model.helper;

/**
 *
 * @author Pahansith
 */
public class ItemTableModel {
    private String detailCode;
    private String sellerCode;
    private String itemCode;
    private String description;
    private double supplyPrice;
    private int updateQty;
    private double amount;
    private String brand;
    
    
    public ItemTableModel() {
    }

    public ItemTableModel(String detailCode, String sellerCode, String itemCode, String description, double supplyPrice, int updateQty, double amount, String brand) {
        this.detailCode = detailCode;
        this.sellerCode = sellerCode;
        this.itemCode = itemCode;
        this.description = description;
        this.supplyPrice = supplyPrice;
        this.updateQty = updateQty;
        this.amount = amount;
        this.brand = brand;
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
     * @return the sellerCode
     */
    public String getSellerCode() {
        return sellerCode;
    }

    /**
     * @param sellerCode the sellerCode to set
     */
    public void setSellerCode(String sellerCode) {
        this.sellerCode = sellerCode;
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
     * @return the supplyPrice
     */
    public double getSupplyPrice() {
        return supplyPrice;
    }

    /**
     * @param supplyPrice the supplyPrice to set
     */
    public void setSupplyPrice(double supplyPrice) {
        this.supplyPrice = supplyPrice;
    }

    /**
     * @return the updateQty
     */
    public int getUpdateQty() {
        return updateQty;
    }

    /**
     * @param updateQty the updateQty to set
     */
    public void setUpdateQty(int updateQty) {
        this.updateQty = updateQty;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    
}
