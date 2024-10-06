package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class productDBUtil {
	private static boolean isSuccess;

	// method
	public static boolean updateproduct(int productId, String productName, String description, double price,
			String category, int stockQuantity, String color, int warranty) {

		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "UPDATE products SET product_name = '" + productName + "', description = '" + description
					+ "', price = " + price + ", category = '" + category + "', stock_quantity = " + stockQuantity
					+ ", colour = '" + color + "', warranty = " + warranty + " WHERE product_id = " + productId;

			int rs = stmt.executeUpdate(sql);

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
	public static List<product> validate(String productid) {

		ArrayList<product> product = new ArrayList<>();

		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "SELECT * FROM products WHERE product_id = '" + productid + "'";
			ResultSet rs = stmt.executeQuery(sql);

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

				product p = new product(pid, pname, pdescription, pprice, pcategory, pquantity, image, color, warranty);

				product.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace(); // default method for print
		}

		return product;

	}

	// method
	public static boolean insertProduct(String productName, String description, double price, String category,
            int stockQuantity, String image, String colour, int warranty) {

    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "admin123";
    boolean isSuccess = false;

    try {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        Statement stmt = con.createStatement();

        String sql = "INSERT INTO products VALUES (0, '" + productName + "', '" + description + "', " + price
                + ", '" + category + "', " + stockQuantity + ", '" + image + "', '" + colour + "', " + warranty + ")";

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
	// method
	public static List<product> getProductDetails(int productid) {

		ArrayList<product> product = new ArrayList<>();

		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "SELECT * FROM products WHERE product_id = '" + productid + "'";
			ResultSet rs = stmt.executeQuery(sql);

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

				product p = new product(pid, pname, pdescription, pprice, pcategory, pquantity, image, color, warranty);

				product.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace(); // default method for print
		}

		return product;

	}

	public static boolean deleteProductDetails(int productid) {

		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "DELETE FROM products WHERE product_id = '" + productid + "'";

			int rs = stmt.executeUpdate(sql);

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
	public static List<product> getProductDetails() {

		ArrayList<product> product = new ArrayList<>();

		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "SELECT * FROM products";
			ResultSet rs = stmt.executeQuery(sql);

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

				product p = new product(pid, pname, pdescription, pprice, pcategory, pquantity, image, color, warranty);

				product.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace(); // default method for print
		}

		return product;

	}

	public static List<product> getProductDetails(String Category) {

		ArrayList<product> product = new ArrayList<>();

		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "SELECT * FROM products WHERE category = '" + Category + "'";
			ResultSet rs = stmt.executeQuery(sql);

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

				product p = new product(pid, pname, pdescription, pprice, pcategory, pquantity, image, color, warranty);

				product.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace(); // default method for print
		}

		return product;

	}

	public static String getStockQuantityStatus(int stockQuantity) {

		String stockStatus;

		if (stockQuantity > 0) {

			stockStatus = "In Stock";
		} else {
			stockStatus = "Out of Stock";
		}
		return stockStatus + " (" + stockQuantity + " available)" + "</p>";

	}

}
