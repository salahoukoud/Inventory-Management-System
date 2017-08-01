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
public class ItemDetail {
    private String detailCode;
    private String invoiceNumber;
    private String itemCode;
    private double buyingPrice;
    private int qtyOfEachItem;
    private double totalBuyingPrice;
    private String supplierCode;
    
    public ItemDetail() {
    }

    public ItemDetail(String detailCode, String invoiceNumber, String itemCode, double buyingPrice, int qtyOfEachItem, double totalBuyingPrice, String supplierCode) {
        this.detailCode = detailCode;
        this.invoiceNumber = invoiceNumber;
        this.itemCode = itemCode;
        this.buyingPrice = buyingPrice;
        this.qtyOfEachItem = qtyOfEachItem;
        this.totalBuyingPrice = totalBuyingPrice;
        this.supplierCode = supplierCode;
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
     * @return the buyingPrice
     */
    public double getBuyingPrice() {
        return buyingPrice;
    }

    /**
     * @param buyingPrice the buyingPrice to set
     */
    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    /**
     * @return the qtyOfEachItem
     */
    public int getQtyOfEachItem() {
        return qtyOfEachItem;
    }

    /**
     * @param qtyOfEachItem the qtyOfEachItem to set
     */
    public void setQtyOfEachItem(int qtyOfEachItem) {
        this.qtyOfEachItem = qtyOfEachItem;
    }

    /**
     * @return the totalBuyingPrice
     */
    public double getTotalBuyingPrice() {
        return totalBuyingPrice;
    }

    /**
     * @param totalBuyingPrice the totalBuyingPrice to set
     */
    public void setTotalBuyingPrice(double totalBuyingPrice) {
        this.totalBuyingPrice = totalBuyingPrice;
    }

    /**
     * @return the supplierCode
     */
    public String getSupplierCode() {
        return supplierCode;
    }

    /**
     * @param supplierCode the supplierCode to set
     */
    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }
    
    
    
    
}
