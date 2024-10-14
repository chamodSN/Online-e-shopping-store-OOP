package com.model.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.entities.Review;
import com.model.interfaces.IReview;

import dao.DBConnect;

public class ReviewDBUtil implements IReview{

	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stat = null;
	private static ResultSet rs = null;
	private static ReviewDBUtil instance;

	public List<Review> validate(String reviewId) {

		ArrayList<Review> review = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "SELECT * FROM reviews WHERE review_id = '" + reviewId + "'";

			rs = stat.executeQuery(sql);

			if (rs.next()) {

				int revId = rs.getInt(1);
				int productID = rs.getInt(2);
				int userID = rs.getInt(3);
				int rate = rs.getInt(4);
				String revTxt = rs.getString(5);
				String date = rs.getString(6);

				Review r = new Review(revId, productID, userID, rate, revTxt, date);

				review.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return review;

	}

	public List<Review> getReviews(String productId) {

		ArrayList<Review> review = new ArrayList<>();


		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "SELECT * FROM reviews WHERE product_id = '" + productId + "'";

			rs = stat.executeQuery(sql);

			while (rs.next()) {

				int revId = rs.getInt(1);
				int productID = rs.getInt(2);
				int userID = rs.getInt(3);
				int rate = rs.getInt(4);
				String revTxt = rs.getString(5);
				String date = rs.getString(6);

				Review r = new Review(revId, productID, userID, rate, revTxt, date);

				review.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return review;

	}

	public boolean insertReview(String productId, String userId, String rateNumber, String rateText) {

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			LocalDate orderDate = LocalDate.now();
			String sql = "INSERT INTO Reviews VALUES(0, '" + productId + "', '" + userId + "', '" + rateNumber + "', '"
					+ rateText + "', '" + orderDate + "')";

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

	public boolean updateReview(String revid, String productId, String userId, String rating, String review,
			String date) {

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			LocalDate orderDate = LocalDate.now();
			String sql = "UPDATE Reviews SET review_text = '" + review + "', review_date = '" + orderDate
					+ "' WHERE review_id = '" + revid + "'";
			
			System.out.println("SQL: " + sql);

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

	public List<Review> getReviewDetails(String reviewId) {

		int convertedID = Integer.parseInt(reviewId);

		ArrayList<Review> review = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "SELECT * FROM reviews WHERE review_id = '" + convertedID + "'";

			rs = stat.executeQuery(sql);

			while (rs.next()) {

				int revId = rs.getInt(1);
				int productID = rs.getInt(2);
				int userID = rs.getInt(3);
				int rate = rs.getInt(4);
				String revTxt = rs.getString(5);
				String date = rs.getString(6);

				Review r = new Review(revId, productID, userID, rate, revTxt, date);

				review.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return review;

	}
	
	public List<Review> getReviewDetails() {

		ArrayList<Review> review = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "SELECT * FROM reviews";

			rs = stat.executeQuery(sql);

			while (rs.next()) {

				int revId = rs.getInt(1);
				int productID = rs.getInt(2);
				int userID = rs.getInt(3);
				int rate = rs.getInt(4);
				String revTxt = rs.getString(5);
				String date = rs.getString(6);

				Review r = new Review(revId, productID, userID, rate, revTxt, date);

				review.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return review;

	}

	public boolean deleteReview(String id) {

		int convertedID = Integer.parseInt(id);

		try {

			con = DBConnect.getConnection();
			stat = con.createStatement();

			String sql = "DELETE FROM reviews WHERE review_id = '" + convertedID + "'";

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
	
	public static ReviewDBUtil getInstance() {
		if(instance == null) {
			instance = new ReviewDBUtil(); 
		}
		return instance;
	}


}
