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
public class ActivityList {
    
    private int id;
    private int id_day;
    private int id_activity;
    private String hour;
    private int student_quota;
    private int  duration;
    private int id_animator;
    private int level_id;

    public ActivityList(int id, int id_day, int id_activity, String hour, int student_quota, int duration, int id_animator, int level_id) {
        this.id = id;
        this.id_day = id_day;
        this.id_activity = id_activity;
        this.hour = hour;
        this.student_quota = student_quota;
        this.duration = duration;
        this.id_animator = id_animator;
        this.level_id = level_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_day() {
        return id_day;
    }

    public void setId_day(int id_day) {
        this.id_day = id_day;
    }

    public int getId_activity() {
        return id_activity;
    }

    public void setId_activity(int id_activity) {
        this.id_activity = id_activity;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getStudent_quota() {
        return student_quota;
    }

    public void setStudent_quota(int student_quota) {
        this.student_quota = student_quota;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId_animator() {
        return id_animator;
    }

    public void setId_animator(int id_animator) {
        this.id_animator = id_animator;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }
    
    
}
