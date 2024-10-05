package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.order;
import model.orderDBUtil;

@WebServlet("/updateOrderServlet")
public class updateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isTrue;
		
		String orderId = request.getParameter("orderId");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String country = request.getParameter("country");
        String district = request.getParameter("district");
        String shippingAddress = request.getParameter("shippingAdd");
        double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String customerName = request.getParameter("cname");
        String contactNumber = request.getParameter("contactNum");
        int productId = Integer.parseInt(request.getParameter("productId"));			
        
		isTrue = orderDBUtil.updateOrder(orderId, quantity, country, district, shippingAddress, totalPrice, customerId, customerName, contactNumber, productId);
	
		if(isTrue == true) {
			
			List<order> orderData= orderDBUtil.getOrderDetails(orderId);
			request.setAttribute("orderData",orderData);
			
			
			RequestDispatcher dis = request.getRequestDispatcher("order.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	
	}
}
