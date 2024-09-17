package model;

public class review {
	
	private int review_id;
	private int product_id;
	private int user_id;
	private int rating;
	private String review_text;
	private String review_date;
	
	public review(int review_id, int product_id, int user_id, int rating, String review_text, String review_date) {
		this.review_id = review_id;
		this.product_id = product_id;
		this.user_id = user_id;
		this.rating = rating;
		this.review_text = review_text;
		this.review_date = review_date;
	}

	public int getReview_id() {
		return review_id;
	}

	public int getProduct_id() {
		return product_id;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public int getRating() {
		return rating;
	}

	public String getReview_text() {
		return review_text;
	}

	public String getReview_date() {
		return review_date;
	}	

}
