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
import modele.Activity;

/**
 *   int id;
     String description;
     int id_period;
     int tariff;
 * 
 * @author Gonzalo
 */
public class ActivityDAO extends AbstractDataBaseDAO{
    
    public ActivityDAO(DataSource ds) {
        super(ds);
    }
    
     public List<Activity> getListActivitys() {
	 List<Activity> result = new ArrayList<Activity>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM activity");
            while (rs.next()) {
                                             
                Activity activity =  new Activity( rs.getInt("id"), rs.getString("description"), rs.getInt("id_period"), rs.getInt("tariff") );
                result.add(activity);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
    
    
    public void addActivity(String description, int id_period, int tariff){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO activity (description, id_period, tariff) VALUES (?, ?, ?)");
	     ) {
            st.setString(1, description);
            st.setInt(2, id_period);
            st.setInt(3, tariff);
                        
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public Activity getActivity(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT description, id_period, tariff FROM activity WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new Activity(id, rs.getString("description"), rs.getInt("id_period"), rs.getInt("tariff"));
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeActivity(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM activity WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifyActivity(int id, String description, int id_period, int tariff ){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE activity SET description = ?, id_period = ?, tariff = ?  WHERE id = ?");
             ) {
            st.setString(1, description);
            st.setInt(2, id_period);
            st.setInt(3, tariff);
            st.setInt(4, id);
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
}
