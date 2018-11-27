/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import wypozyczalnia.exceptions.NoPlateException;
import wypozyczalnia.exceptions.PlateDuplicateException;

/**
 *
 * @author Skrzymo
 */
public class VehiclesBase implements Serializable {
    private List<Vehicle> vehicles = new LinkedList<>();
    
    public List<Vehicle> getVehicle() {
        return vehicles;
    }
    
    public void addVehicle(Vehicle v) {
		Vehicle tmp = findVehicle(v.getPlate_number());
		if (tmp!=null)
			throw new PlateDuplicateException();
		vehicles.add(v);
	}
    
    public Vehicle removeVehicle(String plate_number) {
	    Vehicle v = findVehicle(plate_number);
	    if (v==null)
	    	throw new NoPlateException();
	    
	    vehicles.remove(v);
	    return v;
	}
    
    public Vehicle findVehicle(String plate_number) {
		for (Vehicle v:vehicles) {
			if (plate_number.equals(v.getPlate_number()))
				return v;
		}
		return null;
	}
    
    @Override
    public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Vehicle v:vehicles) {
			sb.append(v).append("\n");
		}
		return sb.toString();
	}
}
