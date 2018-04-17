/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.sql.DataSource;

/**
 *
 * @author facun
 */
public class enfantDAO extends AbstractDataBaseDAO{
    
    public enfantDAO(DataSource ds) {
        super(ds);
    }
 
    public List<Enfant> getListEnfants() {
        return null;
    }
    
    public void addEnfant(){
    }
    
    public Enfant getEnfant(){
        return null;
    }
    
    public void removeEnfant(){
    }
    
    public void modifyEnfant(){
    }
}
