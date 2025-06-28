package com.model.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.entities.Order;
import com.model.interfaces.IOrder;

import dao.DBConnect;

public class OrderDBUtil implements IOrder {

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	private static OrderDBUtil instance;

	@Override
	public List<Order> validate(String orderId) {

		ArrayList<Order> order = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "SELECT * FROM `order` WHERE orderId = '" + orderId + "'";

			rs = stat.executeQuery(sql);

			if (rs.next()) {

				int orderID = rs.getInt(1);
				int quantity = rs.getInt(2);
				String country = rs.getString(3);
				String district = rs.getString(4);
				String shippingAdd = rs.getString(5);
				double totalPrice = rs.getDouble(6);
				int customerId = rs.getInt(7);
				String customerName = rs.getString(8);
				String contactNum = rs.getString(9);
				int productId = rs.getInt(10);
				String productName = rs.getString(11);

				Order o = new Order(orderID, quantity, country, district, shippingAdd, totalPrice, customerId,
						customerName, contactNum, productId, productName);

				order.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return order;

	}

	@Override
	public boolean insertOrder(String customerName, int quantity, String country, String district,
			String contactNumber, String shippingAddress, double totalPrice, int productId, int customerId,
			String productName) {

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "INSERT INTO `order`  VALUES(0, '" + quantity + "', '" + country + "', '" + district + "', '"
					+ shippingAddress + "', '" + totalPrice + "', '" + customerId + "', '" + customerName + "', '"
					+ contactNumber + "', '" + productId + "', '" + productName + "')";
			int rs = stat.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	@Override
	public boolean updateOrder(String orderId, int quantity, String country, String district,
			String shippingAddress, double totalPrice, int customerId, String customerName, String contactNumber,
			int productId) {

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "UPDATE `order` SET quantity='" + quantity + "', country='" + country + "', district='"
					+ district + "', shippingAddress='" + shippingAddress + "', totalPrice='" + totalPrice
					+ "',  customerName='" + customerName + "', contactNumber='" + contactNumber + "' WHERE orderId = '"
					+ orderId + "'";

			int rs = stat.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	// get sertain order details using orderId
	@Override
	public List<Order> getOrderDetails(String orderId) {

		int convertedID = Integer.parseInt(orderId);

		ArrayList<Order> order = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "SELECT * FROM `order` WHERE orderId = '" + convertedID + "'";

			rs = stat.executeQuery(sql);

			while (rs.next()) {

				int orderID = rs.getInt(1);
				int quantity = rs.getInt(2);
				String country = rs.getString(3);
				String district = rs.getString(4);
				String shippingAdd = rs.getString(5);
				double totalPrice = rs.getDouble(6);
				int customerId = rs.getInt(7);
				String customerName = rs.getString(8);
				String contactNum = rs.getString(9);
				int productId = rs.getInt(10);
				String productName = rs.getString(11);

				Order o = new Order(orderID, quantity, country, district, shippingAdd, totalPrice, customerId,
						customerName, contactNum, productId, productName);

				order.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return order;

	}

	// get all orders in data base for the orders.jsp
	@Override
	public List<Order> getOrderDetails() {

		ArrayList<Order> order = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "SELECT * FROM `order`";

			rs = stat.executeQuery(sql);

			while (rs.next()) {

				int orderID = rs.getInt(1);
				int quantity = rs.getInt(2);
				String country = rs.getString(3);
				String district = rs.getString(4);
				String shippingAdd = rs.getString(5);
				double totalPrice = rs.getDouble(6);
				int customerId = rs.getInt(7);
				String customerName = rs.getString(8);
				String contactNum = rs.getString(9);
				int productId = rs.getInt(10);
				String productName = rs.getString(11);

				Order o = new Order(orderID, quantity, country, district, shippingAdd, totalPrice, customerId,
						customerName, contactNum, productId, productName);

				order.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return order;

	}

	@Override
	public boolean deleteOrder(String id) {

		int convertedID = Integer.parseInt(id);

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "DELETE FROM `order` WHERE orderId = '" + convertedID + "'";

			int rs = stat.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;

	}

	public static OrderDBUtil getInstance() {
		if (instance == null) {
			instance = new OrderDBUtil();
		}
		return instance;
	}

	@Override
	public int getProductStock(int productId) {
		int stock = 0;

		try {
			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "SELECT stock_quantity FROM products WHERE product_id = '" + productId + "'";
			rs = stat.executeQuery(sql);

			if (rs.next()) {
				stock = rs.getInt("stock_quantity");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stock;
	}

	@Override
	public boolean deductStock(int productId, int quantity) {
		try {
			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "UPDATE products SET stock_quantity = stock_quantity - " + quantity + " WHERE product_id = '"
					+ productId + "'";
			int rows = stat.executeUpdate(sql);

			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
