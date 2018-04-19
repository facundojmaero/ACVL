/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import modele.Invoice;

/**
 *  private int id;
    private int amount;
    private String date_of_issue;
    private String expiration;
    private int id_family;
    private String payed;
    private String payment_date;
 * 
 * @author Gonzalo
 */
public class InvoiceDAO extends AbstractDataBaseDAO{
    
    public InvoiceDAO(DataSource ds) {
        super(ds);
    }
    
     public List<Invoice> getListInvoices() {
	 List<Invoice> result = new ArrayList<Invoice>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM invoice");
            while (rs.next()) {
                                             
                Invoice invoice =  new Invoice( rs.getInt("id"), rs.getInt("amount"), rs.getString("date_of_issue"), rs.getString("expiration"), 
                        rs.getInt("id_family"),rs.getString("payed"), rs.getString("payment_date"));
                result.add(invoice);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
    
    
    public void addInvoice(int amount, String date_of_issue,String expiration,int id_family, String payed, String payment_date){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO invoice ( amount,  date_of_issue, expiration, id_family, payed, payment_date) VALUES (?, ?, ?,?,?,?)");
	     ) {
            st.setInt(1, amount);
            st.setString(2, date_of_issue);
            st.setString(3, expiration);
             st.setInt(4, id_family);
            st.setString(5, payed);
            st.setString(6, payment_date);

            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public Invoice getInvoice(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT id_day, id_activity, student_quota, hour , duration, id_animator, level_id FROM invoice WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new Invoice( rs.getInt("id"), rs.getInt("amount"), rs.getString("date_of_issue"), rs.getString("expiration"), 
                        rs.getInt("id_family"),rs.getString("payed"), rs.getString("payment_date"));
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeInvoice(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM invoice WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifyInvoice(int id, int amount, String date_of_issue, String expiration,int id_family, String payed, String payment_date){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE invoice SET amount = ?, date_of_issue = ?, expiration = ?,id_family = ?,payed = ?, payment_date = ? WHERE id = ?");
             ) {
              st.setInt(1, amount);
            st.setString(2, date_of_issue);
            st.setString(3, expiration);
             st.setInt(4, id_family);
            st.setString(5, payed);
            st.setString(6, payment_date);
            st.setInt(7, id);
            
            st.executeUpdate();
            
            
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
}
