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
public class PaymentTerm {
    private String termId;
    private String termCategory;
    private int duration;

    public PaymentTerm() {
    }

    public PaymentTerm(String termId, String termCategory, int duration) {
        this.termId = termId;
        this.termCategory = termCategory;
        this.duration = duration;
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
     * @return the termCategory
     */
    public String getTermCategory() {
        return termCategory;
    }

    /**
     * @param termCategory the termCategory to set
     */
    public void setTermCategory(String termCategory) {
        this.termCategory = termCategory;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public String toString(){
        return termCategory;
    }
    
}
