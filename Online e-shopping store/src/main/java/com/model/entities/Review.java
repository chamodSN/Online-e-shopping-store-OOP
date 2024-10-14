package com.model.entities;

public class Review {
	
	private int reviewId;
	private int productId;
	private int userId;
	private int rating;
	private String reviewText;
	private String reviewDate;

	public Review(int reviewId, int productId, int userId, int rating, String reviewText, String reviewDate) {
		super();
		this.reviewId = reviewId;
		this.productId = productId;
		this.userId = userId;
		this.rating = rating;
		this.reviewText = reviewText;
		this.reviewDate = reviewDate;
	}

	public int getReviewId() {
		return reviewId;
	}

	public int getProductId() {
		return productId;
	}

	public int getUserId() {
		return userId;
	}

	public int getRating() {
		return rating;
	}

	public String getReviewText() {
		return reviewText;
	}

	public String getReviewDate() {
		return reviewDate;
	}	

}
