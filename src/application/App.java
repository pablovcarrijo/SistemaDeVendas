package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Clients;
import model.entities.Eletronic;
import model.entities.Food;
import model.entities.Pessoa;
import model.entities.Product;
import model.exceptions.DomainException;

public class App {

	public static void main(String[] args) throws DomainException {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		try {
			Product prodFood = new Food("Maça", 5.00, 10);
			Product prodEletronic = new Eletronic("Celular", 10000.0, 5);
			
			Pessoa client1 = new Clients("Pablo", "pablo.vcarrijo@gmail.com", "01/08/2005", 10010.0,
					1, prodEletronic);
			
			System.out.println(client1.totalPrice());
			System.out.println(client1.totalPrice());
		}
		catch(DomainException e) {
			System.out.println("Error: " + e.getMessage());
		}
			
	}
	
}
