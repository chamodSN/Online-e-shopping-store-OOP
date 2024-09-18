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

@WebServlet("/deleteReviewServlet")
public class deleteReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean isTrue;
		
		String revid = request.getParameter("reviewId");
		
		isTrue = reviewDBUtil.deleteReview(revid);
		
		if(isTrue==true) {
			RequestDispatcher dis = request.getRequestDispatcher("addReview.jsp");
			dis.forward(request, response);
		}else {
			List<review> revData = reviewDBUtil.getReviewDetails(revid);
			request.setAttribute("revData", revData);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("review.jsp");
			dis2.forward(request, response);
		}
		
		
	}

}
