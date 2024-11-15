package com.model.entities;

public class Product {
	
		private int productId;
		private String productName;
		private String description;
		private double price;
		private String category;
		private int stockQuantity;
		private String image;
		private String color;
		private int warranty;
		
		public Product(int productId, String productName, String description, double price, String category,
				int stockQuantity, String image, String color, int warranty) {
			this.productId = productId;
			this.productName = productName;
			this.description = description;
			this.price = price;
			this.category = category;
			this.stockQuantity = stockQuantity;
			this.image = image;
			this.color = color;
			this.warranty = warranty;
		}
		
		//constructor overloading for cart
		public Product(int productId) {
			this.productId = productId;
		}

		//constructor overloading for cart
		public Product(int productId, String productName, double price, String category) {
			this.productId = productId;
			this.productName = productName;
			this.price = price;
			this.category = category;
		}
		
		//constructor overloading for order
		public Product(int productId, String productName) {
			this.productId = productId;
			this.productName = productName;
		}

		public int getProductId() {
			return productId;
		}

		public String getProductName() {
			return productName;
		}

		public String getDescription() {
			return description;
		}

		public double getPrice() {
			return price;
		}

		public String getCategory() {
			return category;
		}

		public int getStockQuantity() {
			return stockQuantity;
		}

		public String getImage() {
			return image;
		}

		public String getColor() {
			return color;
		}

		public int getWarranty() {
			return warranty;
		}

}
