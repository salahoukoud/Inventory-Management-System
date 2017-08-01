/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse.inventory.other;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Pahansith
 */
public class TextFieldHandler {
    
    public static void focusGained(JTextField text){
        text.setText("");
        text.setForeground(new Color(102,102,102));
    }
    
    public static String textCheck(String text){
        if(text.length()<=0){
            return null;
        }
        return text;
    }
    
    public static int numberCheck(String text){
        if(text.length()<=0){
            return 0;
        }
        return Integer.parseInt(text);
    }
    
    public static boolean isAllTextFieldsFilled(JTextField... fields){
        int count = 0;
        for (JTextField field : fields) {
            if (!(field.getText().isEmpty())) {
                count++;
            }
        }
        return count == fields.length;
    }
    
    public static void clearTextFields(JTextField... fields){
        for (JTextField field : fields) {
            field.setText(null);
        }
    }

}
