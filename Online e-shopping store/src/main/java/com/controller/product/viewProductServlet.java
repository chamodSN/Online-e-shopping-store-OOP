package com.controller.product;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.entities.Product;
import com.model.entities.Review;
import com.model.utils.ProductDBUtil;
import com.model.utils.ReviewDBUtil;

@WebServlet("/ViewProductServlet")
public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("productId");

		//ProductDBUtil pDBU = new ProductDBUtil();
		//ReviewDBUtil rDBU = new ReviewDBUtil();

		try {

			List<Product> productData = ProductDBUtil.getInstance().validate(id);
			request.setAttribute("productData", productData);

			List<Review> reviewData = ReviewDBUtil.getInstance().getReviews(id);
			request.setAttribute("reviewData", reviewData);

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher dis = request.getRequestDispatcher("product.jsp");
		dis.forward(request, response);

	}
}
