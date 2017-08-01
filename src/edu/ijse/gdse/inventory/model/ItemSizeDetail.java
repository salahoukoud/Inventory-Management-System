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
public class ItemSizeDetail {
    private String sizeId;
    private String productCode;

    public ItemSizeDetail() {
    }

    public ItemSizeDetail(String sizeId, String productCode) {
        this.sizeId = sizeId;
        this.productCode = productCode;
    }

    /**
     * @return the sizeId
     */
    public String getSizeId() {
        return sizeId;
    }

    /**
     * @param sizeId the sizeId to set
     */
    public void setSizeId(String sizeId) {
        this.sizeId = sizeId;
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
    
    
}
