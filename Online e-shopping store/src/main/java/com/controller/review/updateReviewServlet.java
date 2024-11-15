package com.controller.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.entities.Review;
import com.model.utils.ReviewDBUtil;

@WebServlet("/UpdateReviewServlet")
public class UpdateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ReviewDBUtil rDBU = new ReviewDBUtil();

		boolean isTrue;

		String revid = request.getParameter("reviewId");
		String productId = request.getParameter("productId");
		String userId = request.getParameter("userId");
		String rating = request.getParameter("rating");
		String review = request.getParameter("review");
		String date = request.getParameter("date");

		isTrue = ReviewDBUtil.getInstance().updateReview(revid, productId, userId, rating, review, date);

		System.out.println("Is true value: " + isTrue);

		if (isTrue == true) {
			List<Review> revData = ReviewDBUtil.getInstance().getReviewDetails(revid);
			request.setAttribute("revData", revData);

			RequestDispatcher dis = request.getRequestDispatcher("review.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsucess.jsp");
			dis2.forward(request, response);
		}
	}

}
