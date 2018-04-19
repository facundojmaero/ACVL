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
import modele.ActivityList;

/**
 *
 * private int id;
    private int id_day;
    private int id_activity;
    private String hour;
    private int student_quota;
    private int  duration;
    private int id_animator;
    private int level_id;
    * 
 * @author Gonzalo
 */
public class ActivityListDAO extends AbstractDataBaseDAO{
    
    public ActivityListDAO(DataSource ds) {
        super(ds);
    }
    
     public List<ActivityList> getListActivityLists() {
	 List<ActivityList> result = new ArrayList<ActivityList>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM activity_list");
            while (rs.next()) {
                                             
                ActivityList act_list =  new ActivityList( rs.getInt("id"), rs.getInt("id_day"), rs.getInt("id_activity"), rs.getString("hour"), 
                        rs.getInt("student_quota"),rs.getInt("duration"), rs.getInt("id_animator"), rs.getInt("level_id") );
                result.add(act_list);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
    
    
    public void addActivityList(int id_day, int id_activity,int student_quota,int duration, int id_animator,int level_id, String hour){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO activity_list (id_day, id_activity,  hour, student_quota, duration, id_animator, level_id) VALUES (?, ?, ?, ?, ?, ?, ?)");
	     ) {
            st.setInt(1, id_day);
            st.setInt(2, id_activity);
            st.setString(3, hour);
             st.setInt(4, student_quota);
            st.setInt(5, duration);
            st.setInt(6, id_animator);
            st.setInt(7, level_id);
        
                        
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public ActivityList getActivityList(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT id_day, id_activity, student_quota, hour , duration, id_animator, level_id FROM activity_list WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new ActivityList(id, rs.getInt("id_day"), rs.getInt("id_activity"), rs.getString("hour"), rs.getInt("student_quota"),  rs.getInt("duration"), rs.getInt("id_animator"), rs.getInt("level_id"));
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removeActivityList(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM activity_list WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifyActivityList(int id,int id_day, int id_activity,int student_quota,int duration, int id_animator,int level_id, String hour){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE activity_list SET id_day = ?, id_activity = ?, hour = ?,student_quota = ?,duration = ?, id_animator = ?, level_id = ?    WHERE id = ?");
             ) {
            st.setInt(1, id_day);
            st.setInt(2, id_activity);
            st.setString(3, hour);
             st.setInt(4, student_quota);
            st.setInt(5, duration);
            st.setInt(6, id_animator);
            st.setInt(7, level_id);
            st.setInt(8, id);
            
            st.executeUpdate();
            
            
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
}
