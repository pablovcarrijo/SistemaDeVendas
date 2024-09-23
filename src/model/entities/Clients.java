package model.entities;

import model.exceptions.DomainException;

public class Clients extends Pessoa{

	private Double saldoInicial;
	private Integer quantityBuy;
	private Product product;
	
	public Clients(String name, String email, String dataNascimento, Double saldoInicial,
			Integer quantityBuy, Product product) {
		super(name, email, dataNascimento);
		this.saldoInicial = saldoInicial;
		this.quantityBuy = quantityBuy;
		this.product = product;
	}

	public Double getSaldoInicial() {
		return this.saldoInicial;
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
	public Double totalPrice() throws DomainException {
		if(getQuantityBuy() <= product.getQuantity() && (getSaldoInicial() >= product.newPrice()*getQuantityBuy())) {
			this.saldoInicial -= product.newPrice() * getQuantityBuy();
			return product.newPrice() * getQuantityBuy();
		}
		else if(getQuantityBuy() > product.getQuantity()){
			throw new DomainException("Erro: Quantidade exigida pelo cliente é maior que o estoque");
		}
		else if((product.newPrice() * getQuantityBuy()) > getSaldoInicial()) {
			throw new DomainException("Erro: Saldo insuficiente do cliente!");
		}
		throw new DomainException("Erro inesperado");
	}
	
}
