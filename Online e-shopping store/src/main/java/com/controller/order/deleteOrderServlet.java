package com.controller.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.entities.Order;
import com.model.utils.OrderDBUtil;

@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				boolean isTrue;
						
				String orderId = request.getParameter("orderId");
				
				//OrderDBUtil oDBU = new OrderDBUtil();
						
			    isTrue = OrderDBUtil.getInstance().deleteOrder(orderId);
			    
			    if(isTrue == true) {
					
					RequestDispatcher dis = request.getRequestDispatcher("AddOrder.jsp");
					dis.forward(request, response);
				}else {
					
					List<Order> orderData= OrderDBUtil.getInstance().getOrderDetails(orderId);
					request.setAttribute("orderData",orderData);
					
					RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
					dis2.forward(request, response);
				}
				
			}

}
