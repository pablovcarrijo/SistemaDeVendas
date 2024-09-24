package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		List<Product> listProd = new ArrayList<>();
		List<Pessoa> listClient = new ArrayList<>();
		
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
		
		System.out.println();
		System.out.println("Cliente: ");
		Pessoa client1 = new Clients();
		
		System.out.println("Quantos clientes: ");
		Integer nClients = sc.nextInt();
		sc.nextLine();
		
		try {
			for(int i = 0; i < nClients; i++) {
				System.out.print("Nome do cliente: ");
				String nameClient = sc.nextLine();
				
				System.out.print("Email do cliente: ");
				String email = sc.nextLine();
				
				System.out.print("Data nascimento: ");
				String dataNascimentoString = sc.nextLine();
				LocalDate date = LocalDate.parse(dataNascimentoString, fmt);
				
				System.out.print("Saldo inicial: ");
				Double saldoInicial = sc.nextDouble();
				sc.nextLine();
				
				System.out.print("Name of produt: ");
				String nameOfProduct = sc.nextLine();
				
				System.out.print("Quantidade do produto: ");
				Integer quantityClient = sc.nextInt();
				sc.nextLine();
			
				for(Product ls : listProd) {
					if(nameOfProduct.equals(ls.getName())) {
						client1 = new Clients(nameClient, email, date, saldoInicial,
								ls, quantityClient);
					}
				}
				listClient.add(client1);
				client1.comprar();
				System.out.println(client1.getSaldoInicial());
			}
		}
		catch(DomainException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		String stringPathProduct =
		"C:\\Users\\Pablo Carrijo\\Desktop\\Programação\\Workspace\\arquivos-text\\mercado\\Produtos.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(stringPathProduct, true))) {
			for(Product pd : listProd) {
				bw.write(pd.getName() + ", US$" + pd.getPrice() + ", " + pd.getQuantity());
				bw.newLine();
			}
		}
		catch(IOException e) {
			System.out.println("Erro:" + e.getMessage());
		}
		
		String stringPathClients = 
		"C:\\\\Users\\\\Pablo Carrijo\\\\Desktop\\\\Programação\\\\Workspace\\\\arquivos-text\\\\mercado\\Clients.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(stringPathClients, true))){
			for(Pessoa client : listClient) {
				bw.write("Name: " + client.getName() + ", nascimento: " + client.getDataNascimento() +
						", saldo inicial: US$" + String.format("%.2f", client.totalPrice()));
				bw.newLine();
			}
		}
		catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		String stringPathCompras = 
		"C:\\\\Users\\\\Pablo Carrijo\\\\Desktop\\\\Programação\\\\Workspace\\\\arquivos-text\\\\mercado\\Compras.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(stringPathCompras, true))) {
			for(Pessoa client : listClient) {
				bw.write("Produto: " + client.getProduct().getName() + ", cliente: " + client.getName() 
				+ ", quantidade: " + client.getQuantityBuy() + ", total pagou: " + client.getSaldoInicial());
				bw.newLine();
			}
		}
		catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
	
}
