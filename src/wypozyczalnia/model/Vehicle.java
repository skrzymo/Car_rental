/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.model;

import java.io.Serializable;

/**
 *
 * @author Skrzymo
 */
public  class Vehicle implements ChangeMileage, Serializable {
	
	private String category;
	private String mark;
	private String model;
	private String year;
	private String engine;
	private String colour;
	private int mileage;
    private String plate_number;
	
	
	public Vehicle(){
	}
	
	public Vehicle(String category, String mark, String model, String year, String engine, String colour, int mileage, String plate_number){
		this.category = category;
		this.mark = mark;
		this.model = model;
		this.year = year;
		this.engine = engine;
		this.colour = colour;
		this.mileage = mileage;
                this.plate_number = plate_number;
	}
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

        public String getPlate_number() {
                return plate_number;
        }

        public void setPlate_number(String plate_number) {
                this.plate_number = plate_number;
        }
  
        @Override
        public void changeMileage(int add) {}

        @Override
        public String toString() {
                return "Vehicle{" + "category=" + category + ", mark=" + mark + ", model=" + model + ", year=" + year + ", engine=" + engine + ", colour=" + colour + ", mileage=" + mileage + ", plate_number=" + plate_number + '}';
        }

}

