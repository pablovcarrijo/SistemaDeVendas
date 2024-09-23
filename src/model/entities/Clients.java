package model.entities;

import model.exceptions.DomainException;

public class Clients extends Pessoa{

	private Integer quantityBuy;
	private Product product;
	
	public Clients() {
		super();
	}
	
	public Clients(String name, String email, String dataNascimento, Double saldoInicial,
			Product product, Integer quantityBuy) {
		super(name, email, dataNascimento, saldoInicial);
		this.quantityBuy = quantityBuy;
		this.product = product;
	}
	
	public Integer getQuantityBuy() {
		return this.quantityBuy;
	}

	public void setProduct(Product prod) {
		this.product = prod;
	}
	
	public Product getProduct() {
		return this.product;
	}

	@Override
	public Double totalPrice() {
		return product.newPrice() * getQuantityBuy();
	}
	
	@Override 
	public void comprar() throws DomainException{
		if(getQuantityBuy() <= product.getQuantity() && (getSaldoInicial() >= totalPrice())) {
			setSaldoInicial(getSaldoInicial() - (product.newPrice()*getQuantityBuy()));
		}
		else if(getQuantityBuy() > product.getQuantity()){
			throw new DomainException("Erro: Quantidade exigida pelo cliente é maior que o estoque");
		}
		else if((product.newPrice() * getQuantityBuy()) > getSaldoInicial()) {
			throw new DomainException("Erro: Saldo insuficiente do cliente!");
		}
	}
	
}
