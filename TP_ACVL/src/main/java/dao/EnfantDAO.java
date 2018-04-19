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
import modele.Enfant;


/**
 *
 * @author facun
 */
public class EnfantDAO extends AbstractDataBaseDAO{
    
    public EnfantDAO(DataSource ds) {
        super(ds);
    }
 
    public List<Enfant> getListEnfants() {
        List<Enfant> result = new ArrayList<Enfant>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM enfant");
            while (rs.next()) {
                                          
                Enfant enfant =
                    new Enfant(rs.getInt("id"), rs.getInt("id_family"), rs.getString("name"), rs.getString("surname"), 
                            rs.getString("gender"), rs.getString("date_of_birth"), rs.getInt("id_regime"), rs.getInt("level_id"), rs.getInt("id_period") );
                result.add(enfant);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
    
    
    
    public void addEnfant(int id_family, String name, 
             String surname, char gender, String date_of_birth,
             int id_regime, int level_id, int id_periodo){
        
          try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO enfant (id_family, name, surname, gender, date_of_birth, id_regime, level_id, id_period) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
	     ) {
            st.setInt(1, id_family);
            st.setString(2, name);
            st.setString(3, surname);
            st.setString(4, Character.toString(gender));
            st.setString(5, date_of_birth);
            st.setInt(6, id_regime);
            st.setInt(7, level_id);
            st.setInt(8, id_periodo);
            
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public Enfant getEnfant(int id){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT id_family, name, surname, gender, date_of_birth, id_regime, level_id, id_period FROM enfants WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
 
            return  new Enfant(id, rs.getInt("id_family"), rs.getString("name"), rs.getString("surname"), 
                   rs.getString("gender"), rs.getString("date_of_birth"), rs.getInt("id_regime"), rs.getInt("level_id"), rs.getInt("id_period") );
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeEnfant(int id){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM enfant WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void modifyEnfant(int id, int id_family, String name, String surname, String gender, String date_of_birth, int id_regime, int level_id, int id_period){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE enfant SET id_family = ?, name = ?, surname = ?, gender = ?, date_of_birth = ?, id_regime = ?, level_id = ?, id_period = ?  WHERE id = ?");
             ) {
            st.setInt(1, id_family);
            st.setString(2, name);
            st.setString(3, surname);
            st.setString(4, gender);
            st.setString(5, date_of_birth);
             st.setInt(6, id_regime);
            st.setInt(7, level_id);
            st.setInt(8, id_period);
            st.setInt(9, id);
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
        
    }
}
