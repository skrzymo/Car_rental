/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Skrzymo
 */
public class Rent implements Serializable {
    private String clientsPesel;
    private String plateCar;
    private String period;
    private int mileage;
    private String remarks;
    
    public Rent() {
        
    }

    public Rent(String clientsPesel, String plateCar, String period, int mileage, String remarks) {
        this.clientsPesel = clientsPesel;
        this.plateCar = plateCar;
        this.period = period;
        this.mileage = mileage;
        this.remarks = remarks;
    }

    

    public void setClientsPesel(String clientsPesel) {
        this.clientsPesel = clientsPesel;
    }

    public void setPlateCar(String plateCar) {
        this.plateCar = plateCar;
    }

    public String getClientsPesel() {
        return clientsPesel;
    }

    public String getPlateCar() {
        return plateCar;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getMileage() {
        return mileage;
    }
    
    public Vehicle getVehicle(String plateCar) {
        VehiclesBase vb = new VehiclesBase();
        Vehicle v = new Vehicle();
        v = vb.findVehicle(plateCar);
        return v;
    }

    @Override
    public String toString() {
        return "\nNumer rejestracyjny: "+plateCar+" Pesel klienta: "+clientsPesel+" Okres: " + period + "\nPrzejechane kilometry: " + mileage + "\nUwagi: " + remarks;
    }
    
}
