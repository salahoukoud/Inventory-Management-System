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
public class UpdateInventoryItem {
    private String itemCode;
    private int updateQty;

    public UpdateInventoryItem() {
    }

    public UpdateInventoryItem(String itemCode, int updateQty) {
        this.itemCode = itemCode;
        this.updateQty = updateQty;
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
    
}
