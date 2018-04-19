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
import modele.Account;

/**
 *
 * @author Gonzalo
 */
public class AccountDAO extends AbstractDataBaseDAO{
    
    public AccountDAO(DataSource ds) {
        super(ds);
    }
    
     public List<Account> getListAccounts() {
	 List<Account> result = new ArrayList<Account>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM account");
            while (rs.next()) {
                                             
                Account account =  new Account( rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("account_type") );
                result.add(account);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
    
    
    public void addAccount(String username, String password, String account_type){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO account (username, password, account_type) VALUES (?, ?, ?)");
	     ) {
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, account_type);
                        
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public Account getAccount(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT username, password, account_type FROM account WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new Account(id, rs.getString("username"), rs.getString("password"), rs.getString("account_type"));
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeAccount(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM account WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifyAccount(int id, String username, String password, String account_type ){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE account SET username = ?, password = ?, account_type = ?  WHERE id = ?");
             ) {
            st.setString(1, username);
            st.setString(2, password);
            st.setString(3, account_type);
            st.setInt(4, id);
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
}
