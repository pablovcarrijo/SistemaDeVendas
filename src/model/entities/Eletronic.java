package model.entities;

public class Eletronic extends Product{

	public Eletronic(String name, Double price, Integer quantity) {
		super(name, price, quantity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double newPrice() {
		return getPrice() + 10;
	}
	
}
