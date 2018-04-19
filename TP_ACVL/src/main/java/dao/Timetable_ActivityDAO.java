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
import modele.Timetable_Activity;

/**
 * private int id;
    private int id_activity_list;
    private String date;
 * @author Gonzalo
 */
public class Timetable_ActivityDAO extends AbstractDataBaseDAO{
    
    public Timetable_ActivityDAO(DataSource ds) {
        super(ds);
    }
    
    public List<Timetable_Activity> getListTimetable_Activitys() {
	 List<Timetable_Activity> result = new ArrayList<Timetable_Activity>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM timetable_activity");
            while (rs.next()) {
                                             
                Timetable_Activity tt_Activity = new Timetable_Activity(rs.getInt("id"), rs.getInt("id_activity_list"), rs.getString("date"));
                result.add(tt_Activity);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
    
    
    public void addTimetable_Activity(String date, int id_activity_list){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO timetable_activity (id_activity_list,date) VALUES (?,?)");
	     ) {
            st.setInt(1, id_activity_list);
            st.setString(2, date);
         
                        
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public Timetable_Activity getTimetable_Activity(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT id_activity_list,date FROM timetable_activity WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new Timetable_Activity(rs.getInt("id"), rs.getInt("id_activity_list"), rs.getString("date"));
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeTimetable_Activity(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM timetable_activity WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifyTimetable_Activity(int id, String date, int id_activity_list){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE timetable_activity SET id_activity_list = ?, date = ? WHERE id = ?");
             ) {
            st.setInt(1, id_activity_list);
            st.setString(2, date);
            st.setInt(3, id);
            
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
}
