package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.orderDBUtil;


@WebServlet("/addOrderServlet")
public class addOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customerName = request.getParameter("customerName");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
	    String country = request.getParameter("country");
		String district = request.getParameter("district");
		String contactNumber = request.getParameter("contactNumber");
		String shippingAddress = request.getParameter("shippingAddress");
		double totalPrice = Double.parseDouble("765.65"); 
		int productId = Integer.parseInt("187");
		int customerId = 87;
		
		boolean isTrue;
		
		isTrue = orderDBUtil.insertOrder(customerName, quantity, country, district, contactNumber, shippingAddress, totalPrice, productId, customerId);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
	}

}
