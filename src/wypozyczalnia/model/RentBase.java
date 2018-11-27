/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import wypozyczalnia.exceptions.NoClientException;
import wypozyczalnia.exceptions.NoVehicleException;

/**
 *
 * @author Skrzymo
 */
public class RentBase implements Serializable {
    private List<Rent> rents = new LinkedList<>();
    
    public List<Rent> getRent() {
        return rents;
    }
    
    
    public Client findClientsPesel(String pesel,ClientBase cb) {
        for (Client c:cb.getClient()){
            if (c.getPesel().equals(pesel))
                return c;
        }
        return null;
    }
    
    public Vehicle findPlateNumber(String plate_number,VehiclesBase vb) {
        for (Vehicle v:vb.getVehicle()) {
            if (v.getPlate_number().equals(plate_number))
                return v;
        }
        return null;
    }
    
    public void addRent(Rent r, VehiclesBase vb, ClientBase cb) {
        
        Client tmp = findClientsPesel(r.getClientsPesel(),cb);
		if (tmp==null)
			throw new NoClientException();
        Vehicle tmp2 = findPlateNumber(r.getPlateCar(),vb);
                if (tmp2==null){
                        throw new NoVehicleException();}
                else {
                    for (Vehicle v:vb.getVehicle()) {
                        if (v.getPlate_number().equals(r.getPlateCar()))
                            v.changeMileage(r.getMileage());
                    }
                }
		rents.add(r);
        
    }
}
