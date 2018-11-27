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
public class PassengerCar extends Vehicle implements ChangeMileage {
    private String type;
    private String fuel;
    private String transmission;
    private int number_passengers;
    
    public PassengerCar(){
        
    }

    public PassengerCar(String category, String mark, String model, String year, String engine, String colour, int mileage, String plate_number, String type, String fuel, String transmission, int number_passengers) {
        super(category, mark, model, year, engine, colour, mileage, plate_number);
        this.type = type;
        this.fuel = fuel;
        this.transmission = transmission;
        this.number_passengers = number_passengers;
    }

    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber_passengers() {
        return number_passengers;
    }

    public void setNumber_passengers(int number_passengers) {
        this.number_passengers = number_passengers;
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
        return this.getCategory() + "\nMarka: " + this.getMark() + "\nModel: " + this.getModel() + ":\nTyp: "+this.getType() + "\nRok produkcji: "+this.getYear()+
        		"\nSkrzynia biegow: " + this.getTransmission() + "\nPojemnosc silnika: " + this.getEngine() + "\nRodzaj paliwa: " + this.getFuel()+"\nKolor: " +
        		this.getColour() + "\nAkualny przebieg: " + this.getMileage() + "\nLiczba miejsc: " + this.getNumber_passengers() + "\nNumer rejestracyjny: " + this.getPlate_number();
    }
    
    
    
}
