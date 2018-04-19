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
public class Enfant {
    
    private  int id;
    private  int id_family;
    private String name;
    private String surname;
    private String gender;
    private String date_of_birth;
    private int id_regime;
    private int level_id;
    private int id_period;
    
     public Enfant(int id, int id_family, String name, 
             String surname, String gender, String date_of_birth,
             int id_regime, int level_id, int id_period) {
         
        this.id = id ;
        this.id_family = id_family ;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.id_period = id_period;
        this.level_id = level_id;
        this.id_period = id_period;
   }

    public int getId() {
        return id;
    }

    public int getId_family() {
        return id_family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public int getRegime() {
        return id_regime;
    }

    public void setRegime(int regime) {
        this.id_regime = regime;
    }

    public int getLevel() {
        return level_id;
    }

    public void setLevel(int level) {
        this.level_id = level;
    }

    public int getPeriodo() {
        return id_period;
    }

    public void setPeriodo(int periodo) {
        this.id_period = periodo;
    }

    @Override
    public String toString() {
        return "Enfant{" + "id=" + id + ", id_family=" + id_family + ", name=" + name + ", surname=" + surname + ", gender=" + gender + ", date_of_birth=" + date_of_birth + ", regime=" + id_regime + ", level=" + level_id + ", periodo=" + id_period + '}';
    }
    

    
    
}
