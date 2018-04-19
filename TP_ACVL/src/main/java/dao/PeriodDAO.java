/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import modele.Period;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Gonzalo
 */
public class PeriodDAO extends AbstractDataBaseDAO{
    
    public PeriodDAO(DataSource ds) {
        super(ds);
    }
    
      public List<Period> getListPeriods() {
	 List<Period> result = new ArrayList<Period>();
        try (
	     Connection conn = getConn();
	     Statement st = conn.createStatement();
	     ) {
            ResultSet rs = st.executeQuery("SELECT * FROM period");
            while (rs.next()) {
                                             
                Period period =
                    new Period(rs.getInt("id"), rs.getString("period_name"), rs.getString("period_year"), rs.getInt("month_initial"));
                result.add(period);
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
	}
	return result;
    }
   
    
    public void addPeriod(String period_name, String period_year, int month_initial){

        try (
	     Connection conn = getConn();
	     PreparedStatement st = conn.prepareStatement
	       ("INSERT INTO Period (period_name, period_year, month_initial) VALUES (?, ?, ?)");
	     ) {
            st.setString(1, period_name);
            st.setString(2, period_year);
            st.setInt(3, month_initial);
                        
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public Period getPeriod(int id){
        
         try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "SELECT period_name, period_year, month_initial FROM Period WHERE id = ?");
             ) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next();
                                 
            return  new Period(id, rs.getString("period_name"), rs.getString("period_year"), rs.getInt("month_initial"));
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
    
    public void removePeriod(int id){
        
           try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "DELETE FROM Period WHERE id = ?");
             ) {
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
        
    }
    
    public void modifyPeriod(int id, String period_name, String period_year, int month_initial ){
        
        try (
             Connection conn = getConn();
             PreparedStatement st = conn.prepareStatement(
                "UPDATE Period SET period_name = ?, period_year = ?, month_initial = ? WHERE id = ?");
             ) {
            st.setString(1, period_name);
            st.setString(2, period_year);
            st.setInt(3, month_initial);
            st.setInt(4, id);
            st.executeUpdate();
            
        } catch (SQLException e) {
            throw new DAOException("Erreur BD " + e.getMessage(), e);
        }
    }
 
}
