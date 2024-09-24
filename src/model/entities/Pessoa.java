package model.entities;

import java.time.LocalDate;

import model.exceptions.DomainException;

public abstract class Pessoa {

	private String name;
	private String email;
	private LocalDate dataNascimento;
	private Double saldoInicial;
	private Product prod;
	private Integer quantityBuy;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String name, String email, LocalDate dataNascimento, Double saldoInicial, Product prod, Integer quantityBuy) {
		this.name = name;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.saldoInicial = saldoInicial;
		this.prod = prod;
		this.quantityBuy = quantityBuy;
	}
	
	public void setQuantityBuy(Integer quantity) {
		this.quantityBuy = quantityBuy;
	}
	
	public Integer getQuantityBuy() {
		return this.quantityBuy;
	}
	
	public void setProduct(Product prod) {
		this.prod = prod;
	}
	
	public Product getProduct() {
		return this.prod;
	}
	
	public Double getSaldoInicial() {
		return this.saldoInicial;
	}
	
	public void setSaldoInicial(Double amount) {
		this.saldoInicial = amount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public abstract Double totalPrice();
	
	public abstract void comprar() throws DomainException;
	
}
