/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Gonzalo
 */
public class Timetable_Activity {
    
    private int id;
    private int id_activity_list;
    private String date;

    public Timetable_Activity(int id, int id_activity_list, String date) {
        this.id = id;
        this.id_activity_list = id_activity_list;
        this.date = date;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_activity_list() {
        return id_activity_list;
    }

    public void setId_activity_list(int id_activity_list) {
        this.id_activity_list = id_activity_list;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
