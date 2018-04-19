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
import modele.Level;

/**
 *
 * @author Gonzalo
 */
public class LevelDAO extends AbstractDataBaseDAO{
    
    public LevelDAO(DataSource ds) {
        super(ds);
    }
    
    public List<Level> getListLevels() {
	 List<Level> result = new ArrayList<Level>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM school_level");
            while (rs.next()) {
                                             
                Level nivel =
                    new Level(rs.getInt("id"), rs.getString("level_name"), rs.getString("description"), rs.getInt("initial_age"),rs.getInt("final_age"));
                result.add(nivel);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
    
    
    public void addLevel(String level_name, String description, int initial_age, int final_age){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO school_level (level_name, description, initial_age, final_age) VALUES (?, ?, ?, ?)");
	     ) {
            st.setString(1, level_name);
            st.setString(2, description);
            st.setInt(3, initial_age);
            st.setInt(3, final_age);
                        
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public Level getLevel(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT level_name, description, initial_age, final_age FROM school_level WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new Level(id, rs.getString("level_name"), rs.getString("description"), rs.getInt("initial_age"), rs.getInt("final_age"));
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeLevel(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM school_level WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifyLevel(int id, String level_name, String description, int initial_age, int final_age ){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE school_level SET level_name = ?, description = ?, initial_age = ?, final_age = ?  WHERE id = ?");
             ) {
            st.setString(1, level_name);
            st.setString(2, description);
            st.setInt(3, initial_age);
            st.setInt(4, final_age);
            st.setInt(5, id);
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    
    
}
