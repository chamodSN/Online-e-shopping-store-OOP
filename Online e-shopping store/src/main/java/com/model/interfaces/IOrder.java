package com.model.interfaces;

import java.util.List;

import com.model.entities.Order;

public interface IOrder {
		
		public List<Order> validate(String orderId);

		public boolean insertOrder(String customerName, int quantity, String country, String district,
				String contactNumber, String shippingAddress, double totalPrice, int productId, int customerId,
				String productName);

		public boolean updateOrder(String orderId, int quantity, String country, String district,
				String shippingAddress, double totalPrice, int customerId, String customerName, String contactNumber,
				int productId); 
		public List<Order> getOrderDetails(String orderId); 

		public List<Order> getOrderDetails(); 

		public boolean deleteOrder(String id);

}
