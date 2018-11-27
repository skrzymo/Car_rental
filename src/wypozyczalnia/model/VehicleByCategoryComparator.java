/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.model;

import java.util.Comparator;

/**
 *
 * @author Skrzymo
 */
public class VehicleByCategoryComparator implements Comparator<Vehicle>{
    
    public int compare(Vehicle arg0, Vehicle arg1)
    {
        if(arg0.getCategory()==null && arg1.getCategory()==null)
            return 0;
        if (arg0.getCategory()==null)
            return -1;
        if (arg1.getCategory()==null){
            return 1;
        }
        
        return arg0.getCategory().compareTo(arg1.getCategory());
    }
}

