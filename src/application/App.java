package application;

import java.util.ArrayList;
import java.util.List;
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
		
		List<Product> listProd = new ArrayList<>();
		
		System.out.print("Quantos produtos: ");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			System.out.print("Food or eletronic (f/e): ");
			char type = sc.next().toLowerCase().charAt(0);
			sc.nextLine();
			
			System.out.print("Name of product: ");
			String name = sc.nextLine();
			
			System.out.print("Price of product: ");
			Double price = sc.nextDouble();
			
			System.out.print("Quantity in stock: ");
			Integer quantityStock = sc.nextInt();
			sc.nextLine();
			
			if(type == 'f') {
				Product prodFood = new Food(name, price, quantityStock);
				listProd.add(prodFood);
			}
			else if(type == 'e') {
				Product prodEletronic = new Eletronic(name, price, quantityStock);
				listProd.add(prodEletronic);
			}
			else {
				System.out.println("Opção inválida");
				System.exit(0);
			}
		}
		
		try {
			System.out.print("Nome do cliente: ");
			String nameClient = sc.nextLine();
			
			System.out.print("Email do cliente: ");
			String email = sc.nextLine();
			
			System.out.print("Data nascimento: ");
			String dataNascimentoString = sc.nextLine();
			
			System.out.print("Saldo inicial: ");
			Double saldoInicial = sc.nextDouble();
			
			System.out.print("Quantidade do produto: ");
			Integer quantityClient = sc.nextInt();
			sc.nextLine();
			
			System.out.print("Name of produt: ");
			String nameOfProduct = sc.nextLine();
			
			Pessoa client1 = new Clients();
			
			for(Product ls : listProd) {
				if(nameOfProduct.equals(ls.getName())) {
					client1 = new Clients(nameClient, email, dataNascimentoString, saldoInicial,
							ls, quantityClient);
				}
			}
			
			client1.comprar();
			System.out.println(client1.getSaldoInicial());
		}
		catch(DomainException e) {
			System.out.println("Error: " + e.getMessage());
		}
			
	}
	
}
