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
public class SalesPerson {
    private String nicOfSalesPerson;
    private String name;
    private String address;
    private String dateOfBirth;

    public SalesPerson(String nicOfSalesPerson, String name, String address, String dateOfBirth) {
        this.nicOfSalesPerson = nicOfSalesPerson;
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the nicOfSalesPerson
     */
    public String getNicOfSalesPerson() {
        return nicOfSalesPerson;
    }

    /**
     * @param nicOfSalesPerson the nicOfSalesPerson to set
     */
    public void setNicOfSalesPerson(String nicOfSalesPerson) {
        this.nicOfSalesPerson = nicOfSalesPerson;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    
}
