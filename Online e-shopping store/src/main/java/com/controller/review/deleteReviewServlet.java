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

@WebServlet("/DeleteReviewServlet")
public class DeleteReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isTrue;

		String revid = request.getParameter("reviewId");

		//ReviewDBUtil rDBU = new ReviewDBUtil();

		isTrue = ReviewDBUtil.getInstance().deleteReview(revid);

		if (isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("reviews.jsp");
			dis.forward(request, response);
		} else {
			List<Review> revData = ReviewDBUtil.getInstance().getReviewDetails(revid);
			request.setAttribute("revData", revData);

			RequestDispatcher dis2 = request.getRequestDispatcher("review.jsp");
			dis2.forward(request, response);
		}
	}

}
