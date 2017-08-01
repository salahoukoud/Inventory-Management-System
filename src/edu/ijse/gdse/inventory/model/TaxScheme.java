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
public class TaxScheme {
    private String taxId;
    private String taxCategory;
    private double taxRate;

    public TaxScheme() {
    }

    public TaxScheme(String taxId, String taxCategory, double taxRate) {
        this.taxId = taxId;
        this.taxCategory = taxCategory;
        this.taxRate = taxRate;
    }

    /**
     * @return the taxId
     */
    public String getTaxId() {
        return taxId;
    }

    /**
     * @param taxId the taxId to set
     */
    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    /**
     * @return the taxCategory
     */
    public String getTaxCategory() {
        return taxCategory;
    }

    /**
     * @param taxCategory the taxCategory to set
     */
    public void setTaxCategory(String taxCategory) {
        this.taxCategory = taxCategory;
    }

    /**
     * @return the taxRate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * @param taxRate the taxRate to set
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
    
    public String toString(){
        return taxCategory+" - "+taxRate;
    }
    
}
