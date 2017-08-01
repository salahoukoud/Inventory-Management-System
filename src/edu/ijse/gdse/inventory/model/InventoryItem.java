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
public class InventoryItem {
    private String itemCode;
    private String productCode;
    private int minimumQty;
    private double retailPrice;
    private String itemSize;
    private double markup;
    private double discountOfItem;
    private int qtyOnHand;
    private boolean returnStatus;
    private double supplyPrice;
    private String addedDate;
    private String brandName;
    private String gender;
    
    public InventoryItem() {
    }

    public InventoryItem(String itemCode, String productCode, int minimumQty, double retailPrice, String itemSize, double markup, double discountOfItem, int qtyOnHand, boolean returnStatus, double supplyPrice, String addedDate, String brandName, String gender) {
        this.itemCode = itemCode;
        this.productCode = productCode;
        this.minimumQty = minimumQty;
        this.retailPrice = retailPrice;
        this.itemSize = itemSize;
        this.markup = markup;
        this.discountOfItem = discountOfItem;
        this.qtyOnHand = qtyOnHand;
        this.returnStatus = returnStatus;
        this.supplyPrice = supplyPrice;
        this.addedDate = addedDate;
        this.brandName = brandName;
        this.gender = gender;
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
     * @return the productCode
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * @param productCode the productCode to set
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * @return the minimumQty
     */
    public int getMinimumQty() {
        return minimumQty;
    }

    /**
     * @param minimumQty the minimumQty to set
     */
    public void setMinimumQty(int minimumQty) {
        this.minimumQty = minimumQty;
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
     * @return the itemSize
     */
    public String getItemSize() {
        return itemSize;
    }

    /**
     * @param itemSize the itemSize to set
     */
    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    /**
     * @return the markup
     */
    public double getMarkup() {
        return markup;
    }

    /**
     * @param markup the markup to set
     */
    public void setMarkup(double markup) {
        this.markup = markup;
    }

    /**
     * @return the discountOfItem
     */
    public double getDiscountOfItem() {
        return discountOfItem;
    }

    /**
     * @param discountOfItem the discountOfItem to set
     */
    public void setDiscountOfItem(double discountOfItem) {
        this.discountOfItem = discountOfItem;
    }

    /**
     * @return the qtyOnHand
     */
    public int getQtyOnHand() {
        return qtyOnHand;
    }

    /**
     * @param qtyOnHand the qtyOnHand to set
     */
    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    /**
     * @return the returnStatus
     */
    public boolean isReturnStatus() {
        return returnStatus;
    }

    /**
     * @param returnStatus the returnStatus to set
     */
    public void setReturnStatus(boolean returnStatus) {
        this.returnStatus = returnStatus;
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
     * @return the addedDate
     */
    public String getAddedDate() {
        return addedDate;
    }

    /**
     * @param addedDate the addedDate to set
     */
    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    /**
     * @return the brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @param brandName the brandName to set
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    
}
