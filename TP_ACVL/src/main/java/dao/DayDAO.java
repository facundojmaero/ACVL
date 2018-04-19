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
import modele.Day;

/**
 *
 *   private int id;
    private String day;
    * 
 * @author Gonzalo
 */
public class DayDAO extends AbstractDataBaseDAO{
    
    public DayDAO(DataSource ds) {
        super(ds);
    }
    
    public List<Day> getListDays() {
	 List<Day> result = new ArrayList<Day>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM day");
            while (rs.next()) {
                                             
                Day day =
                    new Day(rs.getInt("id"), rs.getString("day"));
                result.add(day);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
    
    
    public void addDay(String day){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO day (day) VALUES (?)");
	     ) {
            st.setString(1, day);
         
                        
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public Day getDay(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT day FROM day WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new Day(rs.getInt("id"), rs.getString("day"));
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeDay(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM day WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifyDay(int id, String day){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE day SET day = ? WHERE id = ?");
             ) {
            st.setString(1, day);
            st.setInt(2, id);
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
}
