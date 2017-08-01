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
public class SelectedItem {
    private String itemCode;
    private String description;
    private double soldPrice;
    private int soldQty;
    private double discount;

    public SelectedItem(String itemCode, String description, double soldPrice, int soldQty,double discount) {
        this.itemCode = itemCode;
        this.description = description;
        this.soldPrice = soldPrice;
        this.soldQty = soldQty;
        this.discount = discount;
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
     * @return the soldQty
     */
    public int getSoldQty() {
        return soldQty;
    }

    /**
     * @param soldQty the soldQty to set
     */
    public void setSoldQty(int soldQty) {
        this.soldQty = soldQty;
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
