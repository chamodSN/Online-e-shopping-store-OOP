package com.model.entities;

public class Cart extends Product{

	private int quantity;

	public Cart(int productId, int quantity) {
		super(productId);
		this.quantity = quantity;
	}
	
	

	public Cart(int productId, String productName, double price, String category, int quantity) {
		super(productId, productName, price, category);
		this.quantity = quantity;
	}



	public int getQuantity() {
		return quantity;
	}
	
	

}
