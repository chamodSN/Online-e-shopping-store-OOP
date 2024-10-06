package model;

public class order {

	private int orderId;
	private int quantity;
	private String country;
	private String district;
	private String shippingAddress;
	private double totalPrice;
	private int customerId;
	private String customerName;
	private String contactNumber;
	private int productId;
	private String productName;

	public order(int orderId, int quantity, String country, String district, String shippingAddress, double totalPrice,
			int customerId, String customerName, String contactNumber, int productId, String productName) {
		this.orderId = orderId;
		this.quantity = quantity;
		this.country = country;
		this.district = district;
		this.shippingAddress = shippingAddress;
		this.totalPrice = totalPrice;
		this.customerId = customerId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.productId = productId;
		this.productName = productName;

	}

	public int getOrderId() {
		return orderId;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getCountry() {
		return country;
	}

	public String getDistrict() {
		return district;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

}
