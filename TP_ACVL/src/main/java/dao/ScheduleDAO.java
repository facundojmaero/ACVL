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
import modele.Schedule;

/**
 *  private int id;
    private int id_enfant;
    private String attendance;
    private int id_timetable_activity;
 * 
 * @author Gonzalo
 */
public class ScheduleDAO extends AbstractDataBaseDAO{
    
    public ScheduleDAO(DataSource ds) {
        super(ds);
    }
    
    public List<Schedule> getListSchedules() {
	 List<Schedule> result = new ArrayList<Schedule>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM schedule_activity_enfant");
            while (rs.next()) {
                                             
                Schedule schedule =
                    new Schedule(rs.getInt("id"), rs.getInt("id_enfant"), rs.getString("attendance"), rs.getInt("id_timetable_activity"));
                result.add(schedule);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
    
    
    public void addSchedule(int id_enfant, String attendance, int id_timetable_activity){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO schedule_activity_enfant (id_enfant, attendance, id_timetable_activity) VALUES (?, ?, ?)");
	     ) {
            st.setInt(1, id_enfant);
            st.setString(2, attendance);
            st.setInt(3, id_timetable_activity);
         
                        
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public Schedule getSchedule(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT id_enfant, attendance, id_timetable_activity FROM schedule_activity_enfant WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new Schedule(rs.getInt("id"), rs.getInt("id_enfant"), rs.getString("attendance"), rs.getInt("id_timetable_activity"));
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeSchedule(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM schedule_activity_enfant WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifySchedule(int id, int id_enfant, String attendance, int id_timetable_activity){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE schedule_activity_enfant SET id_enfant = ?, attendance = ?, id_timetable_activity = ?  WHERE id = ?");
             ) {
           st.setInt(1, id_enfant);
            st.setString(2, attendance);
            st.setInt(3, id_timetable_activity);
            st.setInt(4, id);
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
}
