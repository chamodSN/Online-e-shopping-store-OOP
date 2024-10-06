package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class orderDBUtil {

	private static boolean isSuccess;

	public static List<order> validate(String orderId) {

		ArrayList<order> order = new ArrayList<>();

		// db connection
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "SELECT * FROM `order` WHERE orderId = '" + orderId + "'";

			ResultSet rs = stmt.executeQuery(sql);

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

				order o = new order(orderID, quantity, country, district, shippingAdd, totalPrice, customerId,
						customerName, contactNum, productId, productName);

				order.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return order;

	}

	public static boolean insertOrder(String customerName, int quantity, String country, String district,
            String contactNumber, String shippingAddress, double totalPrice, int productId, 
            int customerId, String productName) {

		// db connection
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "INSERT INTO `order`  VALUES(0, '" + quantity + "', '" + country + "', '" + district + "', '"
					+ shippingAddress + "', '" + totalPrice + "', '" + customerId + "', '" + customerName + "', '"
					+ contactNumber + "', '" + productId + "', '" + productName + "')";

			int rs = stmt.executeUpdate(sql);

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

	public static boolean updateOrder(String orderId, int quantity, String country, String district,
			String shippingAddress, double totalPrice, int customerId, String customerName, String contactNumber,
			int productId) {

		// db connection
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "UPDATE `order` SET quantity='" + quantity + "', country='" + country + "', district='"
					+ district + "', shippingAddress='" + shippingAddress + "', totalPrice='" + totalPrice
					+ "',  customerName='" + customerName + "', contactNumber='" + contactNumber + "' WHERE orderId = '"
					+ orderId + "'";

			int rs = stmt.executeUpdate(sql);

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

	public static List<order> getOrderDetails(String orderId) {

		int convertedID = Integer.parseInt(orderId);

		ArrayList<order> order = new ArrayList<>();

		// db connection
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "SELECT * FROM `order` WHERE orderId = '" + convertedID + "'";

			ResultSet rs = stmt.executeQuery(sql);

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

				order o = new order(orderID, quantity, country, district, shippingAdd, totalPrice, customerId,
						customerName, contactNum, productId, productName);

				order.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return order;

	}

	public static List<order> getOrderDetails() {

		ArrayList<order> order = new ArrayList<>();

		// db connection
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "SELECT * FROM `order`";

			ResultSet rs = stmt.executeQuery(sql);

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

				order o = new order(orderID, quantity, country, district, shippingAdd, totalPrice, customerId,
						customerName, contactNum, productId, productName);

				order.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return order;

	}

	public static boolean deleteOrder(String id) {

		int convertedID = Integer.parseInt(id);

		// db connection
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "DELETE FROM `order` WHERE orderId = '" + convertedID + "'";

			int rs = stmt.executeUpdate(sql);

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
}
