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
public class Period {
    
    private final int id;
    private String period_name;
    private String period_year;
    private int month_initial;

    public Period(int id, String period_name, String period_year, int month_initial) {
        this.id = id;
        this.period_name = period_name;
        this.period_year = period_year;
        this.month_initial = month_initial;
    }

    public String getPeriod_name() {
        return period_name;
    }

    public void setPeriod_name(String period_name) {
        this.period_name = period_name;
    }

    public String getPeriod_year() {
        return period_year;
    }

    public void setPeriod_year(String period_year) {
        this.period_year = period_year;
    }

    public int getMonth_initial() {
        return month_initial;
    }

    public void setMonth_initial(int month_initial) {
        this.month_initial = month_initial;
    }

    public int getId() {
        return id;
    }
    
    
    
}
