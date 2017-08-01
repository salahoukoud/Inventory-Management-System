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
public class ItemTagDetail {
    private String productCode;
    private String tagId;

    public ItemTagDetail() {
    }

    public ItemTagDetail(String productCode, String tagId) {
        this.productCode = productCode;
        this.tagId = tagId;
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
     * @return the tagId
     */
    public String getTagId() {
        return tagId;
    }

    /**
     * @param tagId the tagId to set
     */
    public void setTagId(String tagId) {
        this.tagId = tagId;
    }
    
    
}
