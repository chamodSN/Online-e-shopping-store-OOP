package com.controller.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.utils.OrderDBUtil;
import com.model.utils.ProductDBUtil;

@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String customerName = request.getParameter("customerName");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String country = request.getParameter("country");
		String district = request.getParameter("district");
		String contactNumber = request.getParameter("contactNumber");
		String shippingAddress = request.getParameter("shippingAddress");
		double unitPrice = Double.parseDouble(request.getParameter("unitPrice"));
		int productId = Integer.parseInt(request.getParameter("prId"));
		int customerId = Integer.parseInt(request.getParameter("userId"));
		String productName = request.getParameter("prName");
		double totalPrice = unitPrice * quantity;

		boolean isOrderPlaced = false;

		// Step 1: Check stock
		int currentStock = ProductDBUtil.getInstance().getProductStock(productId);
		if (currentStock >= quantity) {
			// Step 2: Place order
			isOrderPlaced = OrderDBUtil.getInstance().insertOrder(customerName, quantity, country, district,
					contactNumber, shippingAddress, totalPrice, productId, customerId, productName);

			// Step 3: Deduct stock if order placed
			if (isOrderPlaced) {
				ProductDBUtil.getInstance().deductStock(productId, quantity);
			}
		}

		if (isOrderPlaced) {
			RequestDispatcher dis = request.getRequestDispatcher("sucess.jsp");
			dis.forward(request, response);
		} else {
			request.setAttribute("errorMsg", "Order failed: Not enough stock or database error.");
			RequestDispatcher dis2 = request.getRequestDispatcher("unsucess.jsp");
			dis2.forward(request, response);
		}
	}
}
