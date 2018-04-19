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
import modele.Admin;

/**
 *private int id;
   private int id_account;
   private String name;
   private String surname;
   private String phone;
   private String address;
   private String date_of_birth;
   private String gender;
 * @author Gonzalo
 */
public class AdminDAO extends AbstractDataBaseDAO{
    
    public AdminDAO(DataSource ds) {
        super(ds);
    }
    
     public List<Admin> getListAdmins() {
	 List<Admin> result = new ArrayList<Admin>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM admin");
            while (rs.next()) {
                                             
                Admin administrator =  new Admin( rs.getInt("id"), rs.getInt("id_account"), rs.getString("name"), rs.getString("surname"), 
                        rs.getString("phone"),rs.getString("address"), rs.getString("date_of_birth"), rs.getString("gender") );
                result.add(administrator);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
    
    
    public void addAdmin(int id_account, String name,String surname,String phone, String address,String date_of_birth, String gender){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO admin (id_account, name, surname, phone, address, date_of_birth, gender) VALUES (?, ?, ?, ?, ?, ?, ?)");
	     ) {
            st.setInt(1, id_account);
            st.setString(2, name);
            st.setString(3, surname);
             st.setString(4, phone);
            st.setString(5, address);
            st.setString(6, date_of_birth);
            st.setString(7, gender);
        
                        
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public Admin getAdmin(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT id_account, name, surname, phone, address, date_of_birth, gender FROM admin WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new Admin( rs.getInt("id"), rs.getInt("id_account"), rs.getString("name"), rs.getString("surname"), 
                        rs.getString("phone"),rs.getString("address"), rs.getString("date_of_birth"), rs.getString("gender") );
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeAdmin(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM admin WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifyAdmin(int id, int id_account, String name,String surname,String phone, String address,String date_of_birth, String gender){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE admin SET id_account = ?, name = ?, surname = ?,phone = ?,address = ?, date_of_birth = ?, gender = ?    WHERE id = ?");
             ) {
            st.setInt(1, id_account);
            st.setString(2, name);
            st.setString(3, surname);
            st.setString(4, phone);
            st.setString(5, address);
            st.setString(6, date_of_birth);
            st.setString(7, gender);
            st.setInt(8, id);
            
            st.executeUpdate();
            
            
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
}
