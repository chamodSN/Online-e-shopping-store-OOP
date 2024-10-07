package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.product;
import model.productDBUtil;
import model.review;
import model.reviewDBUtil;


@WebServlet("/adminViewProductServlet")
public class adminViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("productId");
		
try {
			
			List<product> productData = productDBUtil.validate(id);
			request.setAttribute("productData", productData);
			
			List<review> reviewData = reviewDBUtil.getReviews(id); 
            request.setAttribute("reviewData", reviewData);
			
		}catch( Exception e){
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("admin_product.jsp");
		dis.forward(request, response);
		
		}
}


