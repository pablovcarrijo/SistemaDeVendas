package model.entities;

import java.time.LocalDate;

import model.exceptions.DomainException;

public class Clients extends Pessoa{
	
	public Clients() {
		super();
	}
	
	public Clients(String name, String email, LocalDate dataNascimento, Double saldoInicial,
			Product product, Integer quantityBuy) {
		super(name, email, dataNascimento, saldoInicial, product, quantityBuy);
	}
	
	@Override
	public Double totalPrice() {
		return getProduct().newPrice() * getQuantityBuy();
	}
	
	@Override 
	public void comprar() throws DomainException{
		if(getQuantityBuy() <= getProduct().getQuantity() && (getSaldoInicial() >= totalPrice())) {
			setSaldoInicial(getSaldoInicial() - (getProduct().newPrice()*getQuantityBuy()));
		}
		else if(getQuantityBuy() > getProduct().getQuantity()){
			throw new DomainException("Erro: Quantidade exigida pelo cliente é maior que o estoque");
		}
		else if((getProduct().newPrice() * getQuantityBuy()) > getSaldoInicial()) {
			throw new DomainException("Erro: Saldo insuficiente do cliente!");
		}
	}
	
}
