package com.model.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.model.entities.Cart;
import com.model.entities.Product;

public interface IProduct {
		public boolean updateProduct(int productId, String productName, String description, double price,
				String category, int stockQuantity, String color, int warranty);

		public List<Product> validate(String productid);
		
		public boolean insertProduct(String productName, String description, double price, String category,
	            int stockQuantity, String image, String colour, int warranty);
		
		public List<Product> getProductDetails(int productid);

		public boolean deleteProductDetails(int productid);

		public List<Product> getTop5ProductDetails();
		
		public List<Product> getProductDetails(String Category);
		
		public List<Cart> getCartProducts(ArrayList <Cart> cartList);
		

}
