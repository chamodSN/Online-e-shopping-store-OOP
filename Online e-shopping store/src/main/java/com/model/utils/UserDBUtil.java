package com.model.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.entities.User;
import com.model.interfaces.IUser;

import dao.DBConnect;

public class UserDBUtil  implements IUser{
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	private static UserDBUtil instance;
	
	@Override
	public boolean insertUser(String userName, String password, String email, String image) {

		isSuccess = false;

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "INSERT INTO users VALUES (0,'" + userName + "', '" + password + "', '" + email + "', '"
					+ image + "')";

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
	public boolean updateUser(String id, String userName, String password, String email) {

		try {

			// db connection

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "UPDATE users SET  userName = '" + userName + "', password = '" + password + "', email = '"
					+ email + "' WHERE user_id = '" + id + "'";
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
	public List<User> getUserDetails(String uName) {

		ArrayList<User> user = new ArrayList<>();

		try {
			// db connection

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "SELECT * FROM users WHERE username = '" + uName + "'";

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				int uId = rs.getInt(1);
				String userName = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String image = rs.getString(5);

				// create object from user class
				User u = new User(uId, userName, password, email, image);

				// pass the object to the user array list object

				user.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
	
	@Override
	public  boolean deleteUser(String id) {

		int convertedID = Integer.parseInt(id);

		// db connection
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();

			String sql = "DELETE FROM users WHERE user_id = '" + convertedID + "'";

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
	
	public static UserDBUtil getInstance() {
		if(instance == null) {
			instance = new UserDBUtil(); 
		}
		return instance;
	}


}
