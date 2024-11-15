package com.controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.utils.ReviewDBUtil;

@WebServlet("/AddReviewServlet")
public class AddReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ReviewDBUtil rDBU = new ReviewDBUtil();

		String rateNumber = request.getParameter("rating");
		String rateText = request.getParameter("review");
		String productId = request.getParameter("proId");
		String userId = request.getParameter("userId");

		boolean isTrue;

		isTrue = ReviewDBUtil.getInstance().insertReview(productId, userId, rateNumber, rateText);

		if (isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("sucess.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsucess.jsp");
			dis2.forward(request, response);
		}
	}

}
