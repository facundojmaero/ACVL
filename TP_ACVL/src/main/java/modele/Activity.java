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
public class Activity {
    
    private int id;
    private String description;
    private int id_period;
    private int tariff;

    public Activity(int id, String description, int id_period, int tariff) {
        this.id = id;
        this.description = description;
        this.id_period = id_period;
        this.tariff = tariff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_period() {
        return id_period;
    }

    public void setId_period(int id_period) {
        this.id_period = id_period;
    }

    public int getTariff() {
        return tariff;
    }

    public void setTariff(int tariff) {
        this.tariff = tariff;
    }
    
    
}
