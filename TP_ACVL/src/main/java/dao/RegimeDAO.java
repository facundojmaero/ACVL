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
import modele.Regime;
import modele.Regime;

/**
 *
 *   private final int id;
     private String description;
 * 
 * @author Gonzalo
 */
public class RegimeDAO extends AbstractDataBaseDAO{
    
    public RegimeDAO(DataSource ds) {
        super(ds);
    }
    
      public List<Regime> getListRegimes() {
	 List<Regime> result = new ArrayList<Regime>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM regime");
            while (rs.next()) {
                                             
                Regime regime =
                    new Regime(rs.getInt("id"), rs.getString("description"));
                result.add(regime);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
   
    public void addRegime(String description){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO regime (description) VALUES (?)");
	     ) {
            st.setString(1, description);
         
                        
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public Regime getRegime(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT description FROM regime WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new Regime(rs.getInt("id"), rs.getString("description"));
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeRegime(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM regime WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifyRegime(int id, String description){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE description SET regime = ? WHERE id = ?");
             ) {
            st.setString(1, description);
            st.setInt(2, id);
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
}
