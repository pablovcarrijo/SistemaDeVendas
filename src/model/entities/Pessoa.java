package model.entities;

import model.exceptions.DomainException;

public abstract class Pessoa {

	private String name;
	private String email;
	private String dataNascimento;
	
	public Pessoa(String name, String email, String dataNascimento) {
		this.name = name;
		this.dataNascimento = dataNascimento;
		this.email = email;
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
	
	public abstract Double totalPrice() throws DomainException;
	
}
