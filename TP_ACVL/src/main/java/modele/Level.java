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
public class Level {

    private final int id;
    private String level_name;
    private String description;
    private int initial_age;
    private int final_age;

    public Level(int id, String level_name, String description, int initial_age, int final_age) {
        this.id = id;
        this.level_name = level_name;
        this.description = description;
        this.initial_age = initial_age;
        this.final_age = final_age;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInitial_age() {
        return initial_age;
    }

    public void setInitial_age(int initial_age) {
        this.initial_age = initial_age;
    }

    public int getFinal_age() {
        return final_age;
    }

    public void setFinal_age(int final_age) {
        this.final_age = final_age;
    }
    
    
    
   
    
    
    
}
