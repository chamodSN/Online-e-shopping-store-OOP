package model;

public class product {
	private int productId;
	private String productName;
	private String description;
	private double price;
	private String category;
	private int stockQuantity;
	private String image;
	private String color;
	private int warranty;
	
	public product(int productId, String productName, String description, double price, String category,
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
