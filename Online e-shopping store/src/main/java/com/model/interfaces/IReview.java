package com.model.interfaces;

import java.util.List;

import com.model.entities.Review;


public interface IReview {

	public List<Review> validate(String reviewId);

	public List<Review> getReviews(String productId);

	public boolean insertReview(String productId, String userId, String rateNumber, String rateText); 

	public boolean updateReview(String revid, String productId, String userId, String rating, String review,
			String date); 
	
	public List<Review> getReviewDetails(String reviewId);
	
	public List<Review> getReviewDetails();
	
	public boolean deleteReview(String id);


}
