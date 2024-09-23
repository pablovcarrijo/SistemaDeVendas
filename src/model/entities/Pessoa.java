package model.entities;

import model.exceptions.DomainException;

public abstract class Pessoa {

	private String name;
	private String email;
	private String dataNascimento;
	private Double saldoInicial;
	
	public Pessoa() {
		
	}
	
	public Pessoa(String name, String email, String dataNascimento, Double saldoInicial) {
		this.name = name;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.saldoInicial = saldoInicial;
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public abstract Double totalPrice();
	
	public abstract void comprar() throws DomainException;
	
}
