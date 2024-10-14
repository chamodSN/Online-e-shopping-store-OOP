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

@WebServlet("/ViewOrderServlet")
public class ViewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				String id = request.getParameter("orderId");
				//OrderDBUtil oDBU = new OrderDBUtil();
				
				try {
					
					List<Order> orderData = OrderDBUtil.getInstance().validate(id);
					
					request.setAttribute("orderData", orderData);
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				RequestDispatcher dis = request.getRequestDispatcher("order.jsp");
				dis.forward(request, response);
			}

}
