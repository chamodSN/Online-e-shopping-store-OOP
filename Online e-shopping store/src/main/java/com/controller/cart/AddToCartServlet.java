package com.controller.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.entities.Cart;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		try{
			
			int id = Integer.parseInt(request.getParameter("productId"));

			ArrayList<Cart> cartList = new ArrayList<>();
			
			Cart cItem = new Cart(id, 1);

			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
			
			if (cart_list == null) {
				cartList.add(cItem);
				session.setAttribute("cart-list", cartList);
				response.sendRedirect("index.jsp");
			} else {
				cartList = cart_list;

				boolean exist = false;
				for (Cart c : cart_list) {
					if (c.getProductId() == id) {
						exist = true;
						out.println("<script type='text/javascript'>");
						out.println("alert('Product is already exists in Cart');");
						out.println("location='cart.jsp'");
						out.println("</script>");
					}
				}

				if (!exist) {
					cartList.add(cItem);
					response.sendRedirect("index.jsp");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
