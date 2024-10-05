package model;
import dao.DBConnect;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class userDBUtil {
	
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	
	public static boolean validate(String loginUserName, String loginPassword){
		
		
		try {
			//db connection
			
			con = DBConnect.getConnection();
			stat = con.createStatement();
			
			String sql = "SELECT * FROM users WHERE username = '"+loginUserName+"' AND password = '"+loginPassword+"'";
			
			rs = stat.executeQuery(sql);
			
			if(rs.next()) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean insertUser(String userName,String password, String email, String image) {
		
		isSuccess=false;
		
		try {
			
			//db connection
			
			con = DBConnect.getConnection();
			stat = con.createStatement();
			
			String sql = "INSERT INTO users VALUES (0,'"+userName+"', '"+password+"', '"+email+"', '"+image+"')";
			
			int rs = stat.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public static boolean updateUser(String id,	String userName, String password, String email,	String role) {
		
			try {
			
			//db connection
			
			con = DBConnect.getConnection();
			stat = con.createStatement();
			
			String sql = "UPDATE users SET  userName = '"+userName+"', password = '"+password+"', email = '"+email+"' WHERE user_id = '"+id+"'";
			int rs = stat.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		
			}catch(Exception e) {
				e.printStackTrace();
			}
		return isSuccess;
	}
	
	public static List<user> getUserDetails(String uName){
		
		ArrayList<user> user = new ArrayList<>();
		
		try {
			//db connection
			
			con = DBConnect.getConnection();
			stat = con.createStatement();
			
			String sql = "SELECT * FROM users WHERE username = '"+uName+"'";
			
			rs = stat.executeQuery(sql);
			
			while(rs.next()) {
				int uId = rs.getInt(1);
				String userName = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String image = rs.getString(5);
				
				//create object from user class
				user u = new user(uId, userName, password, email, image);
				
				//pass the object to the user array list object
				
				user.add(u);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static boolean deleteUser(String id) {
		
		int convertedID = Integer.parseInt(id);
		
		//db connection
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			
			String sql = "DELETE FROM users WHERE user_id = '"+convertedID+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
		
	}
	

}
