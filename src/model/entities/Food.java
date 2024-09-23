package model.entities;

public class Food extends Product{

	public Food(String name, Double price, Integer quantity) {
		super(name, price, quantity);
	}
	
	@Override
	public Double newPrice() {
		return getPrice() + 5;
	}

}
