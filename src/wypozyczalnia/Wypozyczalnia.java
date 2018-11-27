/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import wypozyczalnia.exceptions.ClientDuplicateException;
import wypozyczalnia.exceptions.NoClientException;
import wypozyczalnia.exceptions.NoPlateException;
import wypozyczalnia.exceptions.NoVehicleException;
import wypozyczalnia.exceptions.PlateDuplicateException;
import wypozyczalnia.model.Client;
import wypozyczalnia.model.ClientBase;
import wypozyczalnia.model.LightTruck;
import wypozyczalnia.model.Motorcycle;
import wypozyczalnia.model.PassengerCar;
import wypozyczalnia.model.Rent;
import wypozyczalnia.model.RentBase;
import wypozyczalnia.model.Vehicle;
import wypozyczalnia.model.VehicleByCategoryComparator;
import wypozyczalnia.model.VehiclesBase;

/**
 *
 * @author Skrzymo
 */
public class Wypozyczalnia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                try {
			run();
		} catch (Throwable e) {
			System.out.println("Wystapil nieprzewidziany blad:");
			e.printStackTrace(System.out);
		}
    }
    
    private static void menu(VehiclesBase vbase,ClientBase cbase, RentBase rbase) {
        Scanner sc = new Scanner(System.in);
		String option;
		do  {
			System.out.print("Witaj w naszej wypozyczalni!\nMenu glowne\n 1) Klienci\n 2) Pojazdy\n 3) Wypozyczenia\n 0) Wyjscie\nWybierz opcje zatwierdzajac(enter)\n");
			option = sc.nextLine();
			switch (option) {
			case "1": {
                                String option2;
                                do {
                                System.out.println("Menu klienci\n 1) Przegladaj baze klientow\n 2) Dodaj klienta do bazy\n 3) Usun klienta z bazy\n 0) Wroc do menu glownego\nWybierz opcje zatwierdzajac(enter)\n");
                                option2 = sc.nextLine();
                                    switch (option2) {
                                    case "1":
                                        showClientsOption(cbase,sc);
                                        break;
                                    case "2":
                                        addClientOption(cbase,sc);
                                        break;
                                    case "3":
                                        removeClientOption(cbase,sc);
                                    case "0":
                                    	break;
                                    default: 
                                        System.out.println("Brak takiej opcji!");    
                                    }
                                } while (!"0".equals(option2));
                        }break;
			case "2": {
                                String option3;
                                do {
                                System.out.println("Menu pojazdy\n 1) Przegladaj baze pojazdow\n 2) Dodaj pojazd do bazy\n 3) Usun pojazd z bazy\n 0) Wroc do menu glownego\nWybierz opcje zatwierdzajac(enter)");
                                option3 = sc.nextLine();
                                    switch (option3) {
                                    case "1":{
                                        String option5;
                                        do {
                                        System.out.println("Menu baza pojazdow\n 1) Przegladaj baze wszystkich pojazdow\n 2) Przegladaj baze samochodow osobowych\n 3) Przegladaj baze samochodow dostawczych\n 4) Przegladaj baze motocykli\n 0) Wroc do menu pojazdy\nWybierz opcje zatwierdzajac(enter)");
                                        option5 = sc.nextLine();
                                        switch (option5) {
                                        case "1":
                                            showVehiclesOption(vbase,sc);
                                            break;
                                        case "2": {
                                            System.out.println("Lista samochodow osobowych:");
                                            showCategoryVehiclesOption(vbase,sc,"Samochod osobowy");
                                        }   break;
                                        case "3": {
                                            System.out.println("Lista samochodow dostawczych:");
                                            showCategoryVehiclesOption(vbase,sc,"Samochod dostawczy");
                                        }   break;
                                        case "4": {
                                            System.out.println("Lista motocykli:");
                                            showCategoryVehiclesOption(vbase,sc,"Motocykl");
                                        }   break;
                                        case "0":
                                        	break;
                                            default: 
                                        System.out.println("Brak takiej opcji!");    
                                        }
                                        } while (!"0".equals(option5));
                                    }break;
                                    case "2": {
                                        String option6;
                                        do {
                                        System.out.println("Menu dodaj pojazd\n 1) Dodaj samochod osobowy\n 2) Dodaj samochod dostawczy\n 3) Dodaj motocykl\n 0) Wroc do menu pojazdy\nWybierz opcje zatwierdzajac(enter)");
                                        option6 = sc.nextLine();
                                        switch (option6) {
                                        case "1":
                                            addPassengerCarOption(vbase,sc);
                                            break;
                                        case "2": {
                                            addLightTruckOption(vbase,sc);
                                        }   break;
                                        case "3": {
                                            addMotorcycleOption(vbase,sc);
                                        }   break;
                                        case "0":
                                        	break;
                                        default: 
                                            System.out.println("Brak takiej opcji!");    
                                        }
                                        } while (!"0".equals(option6));
                                        
                                    }break;
                                    case "3":
                                        removeVehicleOption(vbase,sc);
                                        break;
                                    case "0":
                                    	break;
                                    default: 
                                        System.out.println("Brak takiej opcji!");    
                                    }
                                } while (!"0".equals(option3));
                        }break;
			case "3": {
                                String option4;
                                do {
                                System.out.println("Menu wypozyczenia\n 1) Przegladaj baze wypozyczen\n 2) Dodaj wypozyczenie do bazy\n 0) Wroc do menu glownego\nWybierz opcje zatwierdzajac(enter)");
                                option4 = sc.nextLine();
                                    switch (option4) {
                                    case "1":
                                        showRentsOption(rbase,sc);
                                        break;
                                    case "2":
                                        addRentOption(rbase,vbase,cbase,sc);
                                        break;
                                    case "0":
                                    	break;
                                    default: 
                                        System.out.println("Brak takiej opcji!");    
                                    }
                                } while (!"0".equals(option4));
                        }break;
			case "0":
				break;
			default: 
				System.out.println("Brak takiej opcji!");
			
			}
		} while (!"0".equals(option));
    }
   
    private static VehiclesBase readFileVehicles(String fileName) throws IOException, ClassNotFoundException {
		if (!Files.exists(Paths.get(fileName))) {
			return new VehiclesBase();
		} else {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			VehiclesBase base = (VehiclesBase) in.readObject();
			in.close();
			return base;
		}
	}
    
    private static void saveFileVehicles(String fileName, VehiclesBase base) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		out.writeObject(base);
		out.close();
	}
    
    private static ClientBase readFileClients(String fileName) throws IOException, ClassNotFoundException {
		if (!Files.exists(Paths.get(fileName))) {
			return new ClientBase();
		} else {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			ClientBase base = (ClientBase) in.readObject();
			in.close();
			return base;
		}
	}
    
    private static void saveFileClients(String fileName, ClientBase base) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		out.writeObject(base);
		out.close();
	}
    
    private static RentBase readFileRents(String fileName) throws IOException, ClassNotFoundException {
		if (!Files.exists(Paths.get(fileName))) {
			return new RentBase();
		} else {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			RentBase base = (RentBase) in.readObject();
			in.close();
			return base;
		}
	}
    
    private static void saveFileRents(String fileName, RentBase base) throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		out.writeObject(base);
		out.close();
	}
    
    private static void addPassengerCarOption(VehiclesBase base, Scanner sc) {
		System.out.println("Podaj dane nowego samochodu osobowego");
		PassengerCar p = new PassengerCar();
		p.setCategory("Samochod osobowy");
                System.out.print("Marka:");
		p.setMark(sc.nextLine());
		System.out.print("Model:");
		p.setModel(sc.nextLine());
                System.out.print("Rok produkcji:");
		p.setYear(sc.nextLine());
		System.out.print("Pojemnosc silnika:");
		p.setEngine(sc.nextLine());
                System.out.print("Rodzaj paliwa:");
		p.setFuel(sc.nextLine());
		System.out.print("Kolor:");
		p.setColour(sc.nextLine());
                System.out.print("Aktualny przebieg:");
		p.setMileage(sc.nextInt());
                sc.nextLine();
		System.out.print("Numer rejestracyjny:");
		p.setPlate_number(sc.nextLine());
                System.out.print("Typ:");
		p.setType(sc.nextLine());
		System.out.print("Rodzaj skrzyni biegow:");
		p.setTransmission(sc.nextLine());
                System.out.println("Liczba miejsc:");
                p.setNumber_passengers(sc.nextInt());
                sc.nextLine();
                
		try {
			base.addVehicle(p);
			System.out.println("Pojazd zostal dodany");
		} catch (PlateDuplicateException e) {
			System.out.println("Istnieje juz w bazie pojazd o podanym numerze rejestracyjnym");
		}
		wait(sc);
	}
    
    private static void addLightTruckOption(VehiclesBase base, Scanner sc) {
		System.out.println("Podaj dane nowego samochodu dostawczego");
		LightTruck l = new LightTruck();
		l.setCategory("Samochod dostawczy");
                System.out.print("Marka:");
		l.setMark(sc.nextLine());
		System.out.print("Model:");
		l.setModel(sc.nextLine());
                System.out.print("Rok produkcji:");
		l.setYear(sc.nextLine());
		System.out.print("Pojemnosc silnika:");
		l.setEngine(sc.nextLine());
                System.out.print("Rodzaj paliwa:");
		l.setFuel(sc.nextLine());
		System.out.print("Kolor:");
		l.setColour(sc.nextLine());
                System.out.print("Aktualny przebieg:");
		l.setMileage(sc.nextInt());
                sc.nextLine();
		System.out.print("Numer rejestracyjny:");
		l.setPlate_number(sc.nextLine());
                System.out.print("Rozmiar przestrzeni zaladunkowej:");
		l.setCarrying_capacity(sc.nextLine());
		System.out.print("Rodzaj skrzyni biegow:");
		l.setTransmission(sc.nextLine());
                
		try {
			base.addVehicle(l);
			System.out.println("Pojazd zostal dodany");
		} catch (PlateDuplicateException e) {
			System.out.println("Istnieje juz w bazie pojazd o podanym numerze rejestrecyjnym");
		}
		wait(sc);
	}
    
    private static void addMotorcycleOption(VehiclesBase base, Scanner sc) {
		System.out.println("Podaj dane nowego motocykla");
		Motorcycle m = new Motorcycle();
		m.setCategory("Motocykl");
                System.out.print("Marka:");
		m.setMark(sc.nextLine());
		System.out.print("Model:");
		m.setModel(sc.nextLine());
                System.out.print("Rok produkcji:");
		m.setYear(sc.nextLine());
		System.out.print("Pojemnosc silnika:");
		m.setEngine(sc.nextLine());
		System.out.print("Kolor:");
		m.setColour(sc.nextLine());
                System.out.print("Aktualny przebieg:");
		m.setMileage(sc.nextInt());
                sc.nextLine();
		System.out.print("Numer rejestracyjny:");
		m.setPlate_number(sc.nextLine());
                System.out.print("Typ:");
		m.setType(sc.nextLine());
                
		try {
			base.addVehicle(m);
			System.out.println("Pojazd zostal dodany");
		} catch (PlateDuplicateException e) {
			System.out.println("Istnieje juz w bazie pojazd o podanym numerze rejestracyjnym");
		}
		wait(sc);
	}
    
    private static void removeVehicleOption(VehiclesBase base, Scanner sc) {
		System.out.println("Podaj numer rejestracyjny pojazdu do usuniecia:");
		String nrrej = sc.nextLine();
		try {
			Vehicle v = base.removeVehicle(nrrej);
			System.out.println("Usunieto pojazd:\n"+v);
		} catch (NoPlateException e) {
			System.out.println("Nie ma w bazie pojazdu o podanym numerze rejestracyjnym");
		}
		wait(sc);
	}
    
    private static void addClientOption(ClientBase base, Scanner sc) {
		System.out.println("Podaj dane nowego klienta");
		Client c = new Client();
		System.out.print("Imie:");
		c.setName(sc.nextLine());
		System.out.print("Nazwisko:");
		c.setSurname(sc.nextLine());
                System.out.println("PESEL:");
                c.setPesel(sc.nextLine());
		
		try {
			base.addClient(c);
			System.out.println("Klient zostal dodany");
		} catch (ClientDuplicateException e) {
			System.out.println("Klient o podanym peselu juz istnieje");
		}
		wait(sc);
		
	}
    
    private static void removeClientOption(ClientBase base, Scanner sc) {
		System.out.println("Podaj pesel klienta do usuniecia:");
		String nr = sc.nextLine();
		try {
			Client c = base.removeClient(nr);
			System.out.println("Usunieto klienta:\n"+c);
		} catch (NoClientException e) {
			System.out.println("Nie klienta o podanym peselu w bazie ");
		}
		wait(sc);
	}
    
    private static void showCategoryVehiclesOption(VehiclesBase base, Scanner sc, String category) {
		for (Vehicle v:base.getVehicle()) {
                    if (v.getCategory().equals(category))
                    System.out.println(v+"\n");
		}
		wait(sc);
	}
    
    private static void showVehiclesOption(VehiclesBase base, Scanner sc) {
		      System.out.println("Lista wszystkich pojazdow:");
                        LinkedList<Vehicle> tmp = new LinkedList<>(base.getVehicle());
                        Collections.sort(tmp,new VehicleByCategoryComparator());
                for (Vehicle v:tmp) {
                    System.out.println(v+"\n");
		}
		wait(sc);
	}    
    
    private static void showClientsOption(ClientBase base, Scanner sc) {
		      System.out.println("Lista klientow:");
                for (Client c:base.getClient()) {
                    System.out.println(c+"\n");
		}
		wait(sc);
	}  
    
    private static void addRentOption(RentBase rb,VehiclesBase vb,ClientBase cb,Scanner sc) {
		System.out.println("Podaj dane nowego wypozyczenia");
		Rent r= new Rent();
                System.out.print("Pesel wypozyczajacego klienta:");
		r.setClientsPesel(sc.nextLine());
		System.out.print("Numer rejestracyjny wypozyczanego auta:");
		r.setPlateCar(sc.nextLine());
                System.out.print("Okres wypozyczenia:");
		r.setPeriod(sc.nextLine());
		System.out.print("Przejechane kilometry:");
		r.setMileage(sc.nextInt());
                sc.nextLine();
                System.out.print("Uwagi:");
		r.setRemarks(sc.nextLine());
                
		try {
			rb.addRent(r, vb, cb);
			System.out.println("Wypozyczenie zostalo dodane");
		} 
                catch (NoClientException e) {
			System.out.println("Nie ma takiego klienta w bazie:");
		}
                catch (NoVehicleException e) {
                        System.out.println("Nie ma takiego pojazdu w bazie:");
                }
		wait(sc);
	}
    
    private static void showRentsOption(RentBase rb,Scanner sc) {
		      System.out.println("Lista wypozyczen:");
                for (Rent r:rb.getRent()) {
                    System.out.println(r);
		}
		wait(sc);
	}
    
    private static void wait(Scanner sc) {
		System.out.println("Wcisnij enter ...");
		sc.nextLine();
	}
    
    private static void run() throws ClassNotFoundException, IOException {
		final String NAZWA_PLIKU_DANYCH= "dane_pojazdy.dat";
                final String NAZWA_PLIKU_DANYCH2= "dane_klienci.dat";
                final String NAZWA_PLIKU_DANYCH3= "dane_wypozyczenia.dat";
		
		// uwaga - po zmianach w klasach, przed uruchomieniem aplikacji usunąć plik z danymi
		VehiclesBase vb = readFileVehicles(NAZWA_PLIKU_DANYCH);
		ClientBase cb = readFileClients(NAZWA_PLIKU_DANYCH2);
                RentBase rb = readFileRents(NAZWA_PLIKU_DANYCH3);
                
		menu(vb,cb,rb);
		
		saveFileVehicles(NAZWA_PLIKU_DANYCH, vb);
                saveFileClients(NAZWA_PLIKU_DANYCH2, cb);
                saveFileRents(NAZWA_PLIKU_DANYCH3, rb);
	}    
    
}
