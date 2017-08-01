/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.gdse.inventory.other;

import java.text.NumberFormat;

/**
 *
 * @author Pahansith
 */
public class IDGenerator {
    public static String getNextId(String prefix,String currentId){
        if(currentId != null){
            String[] split = currentId.split(prefix);
            NumberFormat instance = NumberFormat.getInstance();
            instance.setMinimumIntegerDigits(3);
            instance.setGroupingUsed(false);
            int newNum = Integer.parseInt(split[1])+1;
            String format = instance.format(newNum);
            return prefix+format;
        }else{
            return prefix+"001";
        }
    }
    
    public static String getNextSaleId(String prefix,String currentId){
        if(currentId != null){
            String[] split = currentId.split(prefix);
            NumberFormat instance = NumberFormat.getInstance();
            instance.setMinimumIntegerDigits(4);
            instance.setGroupingUsed(false);
            int newNum = Integer.parseInt(split[1])+1;
            String format = instance.format(newNum);
            return prefix+format;
        }else{
            return prefix+"0001";
        }
    }

    public static String getNextSaleId(String currentId) {
        String numberString = currentId.substring(1);
        String prefix = currentId.substring(0, 1);
        NumberFormat instance = NumberFormat.getInstance();
        instance.setMinimumIntegerDigits(4);
        instance.setGroupingUsed(false);
        int newNum = Integer.parseInt(numberString) + 1;
        String format = instance.format(newNum);
        return prefix + format;
    }
    
    public static String getNextDetailId(String currentId) {
        String numberString = currentId.substring(1);
        String prefix = currentId.substring(0, 1);
        NumberFormat instance = NumberFormat.getInstance();
        instance.setMinimumIntegerDigits(3);
        instance.setGroupingUsed(false);
        int newNum = Integer.parseInt(numberString) + 1;
        String format = instance.format(newNum);
        return prefix + format;
    }
    
    public static String getNextItemCode(String currentId){
        String numberString = currentId.substring(1);
        String prefix = currentId.substring(0, 1);
        NumberFormat instance = NumberFormat.getInstance();
        instance.setMinimumIntegerDigits(3);
        instance.setGroupingUsed(false);
        int newNum = Integer.parseInt(numberString) + 1;
        String format = instance.format(newNum);
        return prefix + format;
    }
    
    public static String getItemMajorId(String prefix,String currentId){
        if(currentId != null){
            String[] split = currentId.split(prefix);
            NumberFormat instance = NumberFormat.getInstance();
            instance.setMinimumIntegerDigits(4);
            instance.setGroupingUsed(false);
            int newNum = Integer.parseInt(split[1])+1;
            String format = instance.format(newNum);
            return prefix+format;
        }else{
            return prefix+"0001";
        }
    }
}
