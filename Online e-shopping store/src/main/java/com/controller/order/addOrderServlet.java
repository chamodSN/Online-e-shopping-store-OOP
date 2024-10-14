package com.controller.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.utils.OrderDBUtil;

@WebServlet("/AddOrderServlet")
public class AddOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			//OrderDBUtil oDBU = new OrderDBUtil();

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

				boolean isTrue;

				isTrue = OrderDBUtil.getInstance().insertOrder(customerName, quantity, country, district, contactNumber, shippingAddress,
						totalPrice, productId, customerId, productName);


				if (isTrue == true) {
					RequestDispatcher dis = request.getRequestDispatcher("sucess.jsp");
					dis.forward(request, response);
				} else {
					RequestDispatcher dis2 = request.getRequestDispatcher("unsucess.jsp");
					dis2.forward(request, response);
				}

			}

}
