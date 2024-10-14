package com.model.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.entities.Cart;
import com.model.entities.Product;
import com.model.interfaces.IProduct;

import dao.DBConnect;

public class ProductDBUtil implements IProduct {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	private static ProductDBUtil instance;

		@Override
		public boolean updateProduct(int productId, String productName, String description, double price,
				String category, int stockQuantity, String color, int warranty) {

			try {

				con = DBConnect.getConnection();
				stat = con.createStatement();

				String sql = "UPDATE products SET product_name = '" + productName + "', description = '" + description
						+ "', price = " + price + ", category = '" + category + "', stock_quantity = " + stockQuantity
						+ ", colour = '" + color + "', warranty = " + warranty + " WHERE product_id = " + productId;

				int rs = stat.executeUpdate(sql);

				if (rs > 0) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}

			} catch (Exception e) {
				e.printStackTrace(); // default method for print
			}
			return isSuccess;
		}

		// method
		@Override
		public List<Product> validate(String productid) {

			ArrayList<Product> product = new ArrayList<>();

			try {

				con = DBConnect.getConnection();
				stat = con.createStatement();

				String sql = "SELECT * FROM products WHERE product_id = '" + productid + "'";
				rs = stat.executeQuery(sql);

				if (rs.next()) {
					int pid = rs.getInt(1);
					String pname = rs.getString(2);
					String pdescription = rs.getString(3);
					float pprice = Math.round(rs.getFloat(4));
					String pcategory = rs.getString(5);
					int pquantity = rs.getInt(6);
					String image = rs.getString(7);
					String color = rs.getString(8);
					int warranty = rs.getInt(9);

					Product p = new Product(pid, pname, pdescription, pprice, pcategory, pquantity, image, color, warranty);

					product.add(p);
				}

			} catch (Exception e) {
				e.printStackTrace(); // default method for print
			}

			return product;

		}

		// method
		@Override
		public boolean insertProduct(String productName, String description, double price, String category,
	            int stockQuantity, String image, String colour, int warranty) {

	    try {

	    	con = DBConnect.getConnection();
			stat = con.createStatement();

	        String sql = "INSERT INTO products VALUES (0, '" + productName + "', '" + description + "', " + price
	                + ", '" + category + "', " + stockQuantity + ", '" + image + "', '" + colour + "', " + warranty + ")";

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
		// method
		@Override
		public List<Product> getProductDetails(int productid) {

			ArrayList<Product> product = new ArrayList<>();

			try {

				con = DBConnect.getConnection();
				stat = con.createStatement();

				String sql = "SELECT * FROM products WHERE product_id = '" + productid + "'";
				rs = stat.executeQuery(sql);

				while (rs.next()) {
					int pid = rs.getInt(1);
					String pname = rs.getString(2);
					String pdescription = rs.getString(3);
					float pprice = Math.round(rs.getFloat(4));
					String pcategory = rs.getString(5);
					int pquantity = rs.getInt(6);
					String image = rs.getString(7);
					String color = rs.getString(8);
					int warranty = rs.getInt(9);

					Product p = new Product(pid, pname, pdescription, pprice, pcategory, pquantity, image, color, warranty);

					product.add(p);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return product;

		}

		@Override
		public boolean deleteProductDetails(int productid) {

			try {

				con = DBConnect.getConnection();
				stat = con.createStatement();

				String sql = "DELETE FROM products WHERE product_id = '" + productid + "'";

				int rs = stat.executeUpdate(sql);

				if (rs > 0) {
					isSuccess = true;
				} else {
					isSuccess = false;
				}

			} catch (Exception e) {
				e.printStackTrace(); // default method for print
			}
			return isSuccess;
		}

		// override for products page
		@Override
		public List<Product> getTop5ProductDetails() {

			ArrayList<Product> product = new ArrayList<>();

			try {

				con = DBConnect.getConnection();
				stat = con.createStatement();

				String sql = "SELECT * FROM test.products WHERE product_id IN (SELECT product_id FROM (SELECT product_id FROM test.reviews GROUP BY product_id ORDER BY SUM(rating) DESC LIMIT 5) AS top_products)";

				rs = stat.executeQuery(sql);

				while (rs.next()) {
					int pid = rs.getInt(1);
					String pname = rs.getString(2);
					String pdescription = rs.getString(3);
					float pprice = Math.round(rs.getFloat(4));
					String pcategory = rs.getString(5);
					int pquantity = rs.getInt(6);
					String image = rs.getString(7);
					String color = rs.getString(8);
					int warranty = rs.getInt(9);

					Product p = new Product(pid, pname, pdescription, pprice, pcategory, pquantity, image, color, warranty);

					product.add(p);
				}

			} catch (Exception e) {
				e.printStackTrace(); // default method for print
			}

			return product;

		}

		@Override
		public List<Product> getProductDetails(String Category) {

			ArrayList<Product> product = new ArrayList<>();

			try {

				con = DBConnect.getConnection();
				stat = con.createStatement();

				String sql = "SELECT * FROM products WHERE category = '" + Category + "'";
				rs = stat.executeQuery(sql);

				while (rs.next()) {
					int pid = rs.getInt(1);
					String pname = rs.getString(2);
					String pdescription = rs.getString(3);
					float pprice = Math.round(rs.getFloat(4));
					String pcategory = rs.getString(5);
					int pquantity = rs.getInt(6);
					String image = rs.getString(7);
					String color = rs.getString(8);
					int warranty = rs.getInt(9);

					Product p = new Product(pid, pname, pdescription, pprice, pcategory, pquantity, image, color, warranty);

					product.add(p);
				}

			} catch (Exception e) {
				e.printStackTrace(); // default method for print
			}

			return product;

		}

		@Override
		public List<Cart> getCartProducts(ArrayList <Cart> cartList){
			
			List<Cart> products = new ArrayList <Cart>();
			
			try {
				
				if(cartList.size()>0) {
					for(Cart item : cartList) {
						
						con = DBConnect.getConnection();
						stat = con.createStatement();

						String sql = "SELECT * FROM products WHERE product_id = '" + item.getProductId() + "'";
						ResultSet rs = stat.executeQuery(sql);

						while (rs.next()) {
							int pid = rs.getInt(1);
							String pname = rs.getString(2);
							float pprice = Math.round(rs.getFloat(4));
							String pcategory = rs.getString(5);

							Cart c = new Cart(pid, pname, pprice, pcategory, 1);
							products.add(c);

						}
						
					}
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			return products;
		}
		
		public static ProductDBUtil getInstance() {
			if(instance == null) {
				instance = new ProductDBUtil(); 
			}
			return instance;
		}


}
