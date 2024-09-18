package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class reviewDBUtil {
	
	private static boolean isSuccess;
	
	public static List<review> validate(String reviewId){
		
		ArrayList<review> review = new ArrayList<>();
		
		//db connection
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			
			String sql = "SELECT * FROM reviews WHERE review_id = '"+reviewId+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				
				int revId = rs.getInt(1);
				int productID = rs.getInt(2);
				int userID = rs.getInt(3);
				int rate = rs.getInt(4);
				String revTxt = rs.getString(5);
				String date = rs.getString(6);
				
				review r = new review(revId, productID, userID, rate, revTxt, date);
				
				review.add(r);
			}
					
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return review;
		
	}
	
	public static boolean insertReview(String productId, String userId, String rateNumber, String rateText) {
		
		//db connection
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			
			LocalDate orderDate = LocalDate.now();
			String sql = "INSERT INTO Reviews VALUES(0, '"+productId+"', '"+userId+"', '"+rateNumber+"', '"+rateText+"', '"+orderDate+"')";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public static boolean updateReview(String revid, String productId, String userId, String rating, String review, String date) {
		
			//db connection
				String url = "jdbc:mysql://localhost:3306/test";
				String user = "root";
				String password = "admin123";
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, user, password);
					Statement stmt = con.createStatement();
					
					LocalDate orderDate = LocalDate.now();
					String sql = "UPDATE Reviews SET review_text = '"+review+"', review_date = '"+orderDate+"' WHERE review_id = '"+revid+"'";
					
					int rs = stmt.executeUpdate(sql);
					
					if(rs > 0) {
						isSuccess = true;
					}else {
						isSuccess = false;
					}			
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				return isSuccess;
	}
	
public static List<review> getReviewDetails(String reviewId){
		
		int convertedID = Integer.parseInt(reviewId);
	
		ArrayList<review> review = new ArrayList<>();
		
		//db connection
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			
			String sql = "SELECT * FROM reviews WHERE review_id = '"+convertedID+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int revId = rs.getInt(1);
				int productID = rs.getInt(2);
				int userID = rs.getInt(3);
				int rate = rs.getInt(4);
				String revTxt = rs.getString(5);
				String date = rs.getString(6);
				
				review r = new review(revId, productID, userID, rate, revTxt, date);
				
				review.add(r);
			}
					
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return review;
		
	}

	public static boolean deleteReview(String id) {
		
		int convertedID = Integer.parseInt(id);
		
		//db connection
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "admin123";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			
			String sql = "DELETE FROM reviews WHERE review_id = '"+convertedID+"'";
			
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
