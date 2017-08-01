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

public class SellInventoryItem {
    private String productName;
    private String description;
    private double retailPrice;
    private double discount;
    private String brand;
    
    public SellInventoryItem() {
        
    }

    public SellInventoryItem(String productName, String description, double retailPrice, double discount, String brand) {
        this.productName = productName;
        this.description = description;
        this.retailPrice = retailPrice;
        this.discount = discount;
        this.brand = brand;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
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
     * @return the retailPrice
     */
    public double getRetailPrice() {
        return retailPrice;
    }

    /**
     * @param retailPrice the retailPrice to set
     */
    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
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
