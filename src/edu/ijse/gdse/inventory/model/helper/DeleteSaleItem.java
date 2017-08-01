/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse.inventory.model.helper;

import edu.ijse.gdse.inventory.view.smallforms.SelectedItemPanel;

/**
 *
 * @author Pahansith
 */
public class DeleteSaleItem {
    private static String itemCode;
    private static SelectedItemPanel panel;

    /**
     * @return the itemCode
     */
    public static String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public static void setItemCode(String itemCode) {
        DeleteSaleItem.itemCode = itemCode;
    }
    
    public static void setItemPanel(SelectedItemPanel panel){
        DeleteSaleItem.panel = panel;
    }
    
    public static SelectedItemPanel getItemPanel(){
        return panel;
    }
    
}
