/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse.inventory.other;

import javax.swing.JComboBox;

/**
 *
 * @author Pahansith
 */
public class ComboBoxHandler {
    public static boolean isAllComboBoxesSelected(JComboBox... boxes){
        int count = 0;
        for (JComboBox boxe : boxes) {
            if (boxe.getSelectedIndex() != -1) {
                count++;
            }
        }
        return count == boxes.length;
    }
    
    public static void clearComboBoxes(JComboBox... boxes){
        for (JComboBox box : boxes) {
            if (box.getItemCount() != 0) {
                box.removeAllItems();
            }
        }
    }
    
}
