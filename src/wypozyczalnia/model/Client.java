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
public class Client implements Serializable {
	private String name;
	private String surname;
	private String pesel;
	
	public Client(){
		}
	public Client(String name, String surname, String pesel){
		this.name=name;
		this.surname=surname;
		this.pesel=pesel;
	}

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        return pesel;
    }    
	
	public String toString(){
		return "Imie: "+name+"\nNazwisko: "+surname+ "\nPESEL: "+pesel;
	}
	
}
