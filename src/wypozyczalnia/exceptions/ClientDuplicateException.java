/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.exceptions;

/**
 *
 * @author Skrzymo
 */
public class ClientDuplicateException extends RuntimeException {
    public ClientDuplicateException() {
		// TODO Auto-generated constructor stub
	}
	public ClientDuplicateException(String message) {
		super(message);
	}
}       