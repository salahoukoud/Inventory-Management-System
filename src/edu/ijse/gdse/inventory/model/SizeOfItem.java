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
public class SizeOfItem {
    private String sizeId;
    private String itemSize;

    public SizeOfItem() {
    }

    public SizeOfItem(String sizeId, String itemSize) {
        this.sizeId = sizeId;
        this.itemSize = itemSize;
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
    public String toString(){
        return itemSize;
    }
    
    
}
