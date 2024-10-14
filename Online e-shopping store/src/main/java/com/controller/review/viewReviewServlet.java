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

@WebServlet("/ViewReviewServlet")
public class ViewReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ReviewDBUtil rDBU = new ReviewDBUtil();

		String id = request.getParameter("reviewId");

		try {
			List<Review> revData = ReviewDBUtil.getInstance().validate(id);

			request.setAttribute("revData", revData);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dis = request.getRequestDispatcher("review.jsp");
		dis.forward(request, response);

	}

}
