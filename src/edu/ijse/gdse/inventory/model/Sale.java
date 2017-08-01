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
public class Sale {
    private String billNumber;
    private String nicOfSalesPerson;
    private String billDate;
    private double discount;
    private double totalAmount;
    private double recievedCash;
    private double balance;
    private double tax;
    public Sale(String billNumber, String nicOfSalesPerson, String billDate, double discount, double totalAmount, double recievedCash, double balance ,double tax) {
        this.billNumber = billNumber;
        this.nicOfSalesPerson = nicOfSalesPerson;
        this.billDate = billDate;
        this.discount = discount;
        this.totalAmount = totalAmount;
        this.recievedCash = recievedCash;
        this.balance = balance;
        this.tax = tax;
    }

    /**
     * @return the billNumber
     */
    public String getBillNumber() {
        return billNumber;
    }

    /**
     * @param billNumber the billNumber to set
     */
    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
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
     * @return the billDate
     */
    public String getBillDate() {
        return billDate;
    }

    /**
     * @param billDate the billDate to set
     */
    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the recievedCash
     */
    public double getRecievedCash() {
        return recievedCash;
    }

    /**
     * @param recievedCash the recievedCash to set
     */
    public void setRecievedCash(double recievedCash) {
        this.recievedCash = recievedCash;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the tax
     */
    public double getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(double tax) {
        this.tax = tax;
    }
    
    
}
