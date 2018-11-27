/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.model;

/**
 *
 * @author Skrzymo
 */
public class LightTruck extends Vehicle implements ChangeMileage {
    private String fuel;
    private String carrying_capacity;
    private String transmission;

    public LightTruck() {

    }

    public LightTruck(String category, String mark, String model, String year, String engine, String colour, int mileage, String plate_number, String fuel, String carrying_capacity, String transmission) {
        super(category, mark, model, year, engine, colour, mileage, plate_number);
        this.fuel = fuel;
        this.carrying_capacity = carrying_capacity;
        this.transmission = transmission;
    }

    public String getCarrying_capacity() {
        return carrying_capacity;
    }

    public void setCarrying_capacity(String carrying_capacity) {
        this.carrying_capacity = carrying_capacity;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
    
    public void changeMileage(int add){
        this.setMileage(this.getMileage()+add);
    }
    
    @Override
    public String toString() {
        return this.getCategory() + ":\nMarka: " + this.getMark() + "\nModel: " + this.getModel() + "\nRok produkcji: " + this.getYear() + 
                "\nSkrzynia biegow: " + this.getTransmission() + "\nPojemnosc silnika: " + this.getEngine() + "\nRodzaj paliwa: " + this.getFuel() + 
                "\nKolor: " + this.getColour() + "\nAktualny przebieg: " + this.getMileage() + "\nWielkosc przestrzeni zaladunkowej: " + this.getCarrying_capacity() + 
                "\nPNumer rejestracyjny: "+this.getPlate_number();
    }
    
    
}
