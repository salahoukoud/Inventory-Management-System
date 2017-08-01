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
public class Vendor {
    private String vendorId;
    private String termId;
    private String taxId;
    private String name;
    private String address;
    private int telephoneNumber;
    private double creditLimit;
    private String emailAddress;
    private int mobileNumber;
    private int fax;
    private String webSite;
    private String company;
    private boolean taxStatus;

    public Vendor() {
    }

    public Vendor(String vendorId,String taxId, String termId, String name, String address, int telephoneNumber, double creditLimit, String emailAddress, int mobileNumber, int fax, String webSite, String company, boolean taxStatus) {
        this.vendorId = vendorId;
        this.termId = termId;
        this.taxId = taxId;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
        this.mobileNumber = mobileNumber;
        this.fax = fax;
        this.webSite = webSite;
        this.company = company;
        this.taxStatus = taxStatus;
    }

    /**
     * @return the vendorId
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     * @param vendorId the vendorId to set
     */
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * @return the termId
     */
    public String getTermId() {
        return termId;
    }

    /**
     * @param termId the termId to set
     */
    public void setTermId(String termId) {
        this.termId = termId;
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
     * @return the telephoneNumber
     */
    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * @param telephoneNumber the telephoneNumber to set
     */
    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * @return the creditLimit
     */
    public double getCreditLimit() {
        return creditLimit;
    }

    /**
     * @param creditLimit the creditLimit to set
     */
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the mobileNumber
     */
    public int getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return the fax
     */
    public int getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(int fax) {
        this.fax = fax;
    }

    /**
     * @return the webSite
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * @param webSite the webSite to set
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the taxStatus
     */
    public boolean isTaxStatus() {
        return taxStatus;
    }

    /**
     * @param taxStatus the taxStatus to set
     */
    public void setTaxStatus(boolean taxStatus) {
        this.taxStatus = taxStatus;
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

    public String toString(){
        return  name +" - "+vendorId ;
    }
    
    
}
