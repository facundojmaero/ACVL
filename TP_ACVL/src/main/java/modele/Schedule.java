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
public class Schedule {
    
    private int id;
    private int id_enfant;
    private String attendance;
    private int id_timetable_activity;

    public Schedule(int id, int id_enfant, String attendance, int id_timetable_activity) {
        this.id = id;
        this.id_enfant = id_enfant;
        this.attendance = attendance;
        this.id_timetable_activity = id_timetable_activity;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public int getId_timetable_activity() {
        return id_timetable_activity;
    }

    public void setId_timetable_activity(int id_timetable_activity) {
        this.id_timetable_activity = id_timetable_activity;
    }
    
    
    
}
