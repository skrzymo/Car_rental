/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import wypozyczalnia.exceptions.ClientDuplicateException;
import wypozyczalnia.exceptions.NoClientException;

/**
 *
 * @author Skrzymo
 */
public class ClientBase implements Serializable {
    private List<Client> clients = new LinkedList<>();
    
    public List<Client> getClient() {
        return clients;
    }
    
    public void addClient(Client c) {
		Client tmp = findClient(c.getPesel());
		if (tmp!=null)
			throw new ClientDuplicateException();
		clients.add(c);
	}
    
    public Client removeClient(String pesel) {
	    Client c = findClient(pesel);
	    if (c==null)
	    	throw new NoClientException();
	    
	    clients.remove(c);
	    return c;
	}
    
    public Client findClient(String pesel) {
		for (Client c:clients) {
			if (c.getPesel().equals(pesel))
				return c;
		}
		return null;
	}
    
    public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Client c:clients) {
			sb.append(c).append("\n");
		}
		return sb.toString();
	}
}

