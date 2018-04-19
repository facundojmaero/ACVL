/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Gonzalo
 */
public class Invoice {
    
    private int id;
    private int amount;
    private String date_of_issue;
    private String expiration;
    private int id_family;
    private String payed;
    private String payment_date;

    public Invoice(int id, int amount, String date_of_issue, String expiration, int id_family, String payed, String payment_date) {
        this.id = id;
        this.amount = amount;
        this.date_of_issue = date_of_issue;
        this.expiration = expiration;
        this.id_family = id_family;
        this.payed = payed;
        this.payment_date = payment_date;
    }

        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate_of_issue() {
        return date_of_issue;
    }

    public void setDate_of_issue(String date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public int getId_family() {
        return id_family;
    }

    public void setId_family(int id_family) {
        this.id_family = id_family;
    }

    public String getPayed() {
        return payed;
    }

    public void setPayed(String payed) {
        this.payed = payed;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }
    
    
    
    
}
