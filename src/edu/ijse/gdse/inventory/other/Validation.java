/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse.inventory.other;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Pahansith
 */
public class Validation {
    public static void validateOnlyForNumbers(KeyEvent evt){
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)) evt.consume();
    }
    
    public static void validateOnlyForCharacters(KeyEvent evt){
        char c = evt.getKeyChar();
        if(Character.isDigit(c)) evt.consume();
    }
    
}
