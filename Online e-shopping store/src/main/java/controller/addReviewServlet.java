package controller;

import model.reviewDBUtil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.reviewDBUtil;


@WebServlet("/addReviewServlet")
public class addReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rateNumber = request.getParameter("rating");
		String rateText = request.getParameter("review");
		String productId = "101";
		String userId = "102";
		
		boolean isTrue;
		
		isTrue = reviewDBUtil.insertReview(productId, userId,  rateNumber, rateText);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("sucess.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsucess.jsp");
			dis2.forward(request, response);
		}

	}

}
