package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.review;
import model.reviewDBUtil;


@WebServlet("/updateReviewServlet")
public class updateReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isTrue;
		
		String revid = request.getParameter("reviewId");
		String productId = request.getParameter("productId");
		String userId = request.getParameter("userId");
		String rating = request.getParameter("rating");
		String review = request.getParameter("review");
		String date = request.getParameter("date");
		
		isTrue = reviewDBUtil.updateReview(revid, productId, userId, rating, review, date);
		
		if(isTrue==true) {
			List<review> revData = reviewDBUtil.getReviewDetails(revid);
			request.setAttribute("revData", revData);
			
			RequestDispatcher dis = request.getRequestDispatcher("review.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsucess.jsp");
			dis2.forward(request, response);
		}
	}

}