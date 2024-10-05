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

@WebServlet("/deleteOrderServlet")
public class deleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isTrue;
				
		String orderId = request.getParameter("orderId");
				
	    isTrue = orderDBUtil.deleteOrder(orderId);
	    
	    if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("AddOrder.jsp");
			dis.forward(request, response);
		}else {
			
			List<order> orderData= orderDBUtil.getOrderDetails(orderId);
			request.setAttribute("orderData",orderData);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
		
	}

}
