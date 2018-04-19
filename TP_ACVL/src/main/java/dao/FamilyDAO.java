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
import modele.Family;

/**
 * private int id;
     private String name_family;
      private String phone;
       private String address;
        private int id_account;
 * 
 * @author Gonzalo
 */
public class FamilyDAO extends AbstractDataBaseDAO{
    
    public FamilyDAO(DataSource ds) {
        super(ds);
    }
    
     public List<Family> getListFamilys() {
	 List<Family> result = new ArrayList<Family>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM family");
            while (rs.next()) {
                                             
                Family family =  new Family( rs.getInt("id"), rs.getString("name_family"), rs.getString("phone"), rs.getString("address"), rs.getInt("id_account") );
                result.add(family);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
    
    
    public void addFamily(String name_family, String phone, String address, int id_account){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO family (name_family, phone, address, id_account) VALUES (?, ?, ?, ?)");
	     ) {
            st.setString(1, name_family);
            st.setString(2, phone);
            st.setString(3, address);
            st.setInt(4, id_account);
                        
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public Family getFamily(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT name_family, phone, address, id_account FROM family WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new Family( rs.getInt("id"), rs.getString("name_family"), rs.getString("phone"), rs.getString("address"), rs.getInt("id_account") );
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeFamily(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM family WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifyFamily(int id, String name_family, String phone, String address, int id_account){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE family SET name_family = ?, phone = ?, address = ?, id_account = ?  WHERE id = ?");
             ) {
             st.setString(1, name_family);
            st.setString(2, phone);
            st.setString(3, address);
            st.setInt(4, id_account);
            st.setInt(5, id);
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    
    
}
