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
import modele.Animator;

/**
    *private int id;
    private String name;
    private String surname;
    private String phone;
    * 
    * 
 * @author Gonzalo
 */
public class AnimatorDAO extends AbstractDataBaseDAO{
    
    public AnimatorDAO(DataSource ds) {
        super(ds);
    }
    
    public List<Animator> getListAnimators() {
	 List<Animator> result = new ArrayList<Animator>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM animator");
            while (rs.next()) {
                                             
                Animator animator =
                    new Animator(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("phone"));
                result.add(animator);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
    
    
    public void addAnimator(String name, String surname, String phone){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO animator (name, surname, phone) VALUES (?, ?, ?)");
	     ) {
            st.setString(1, name);
            st.setString(2, surname);
            st.setString(3, phone);
         
                        
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public Animator getAnimator(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT name, surname, phone FROM animator WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new Animator(rs.getInt("id"), rs.getString("name"), rs.getString("surname"), rs.getString("phone"));
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeAnimator(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM animator WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifyAnimator(int id, String name, String surname, String phone){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE animator SET name = ?, surname = ?, phone = ?  WHERE id = ?");
             ) {
            st.setString(1, name);
            st.setString(2, surname);
            st.setString(3, phone);
            st.setInt(4, id);
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
}
