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
import com.model.utils.ProductDBUtil;

@WebServlet("/UpdateProductServlet")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				boolean isTrue;
				//ProductDBUtil pDBU = new ProductDBUtil();
				
				int prId = Integer.parseInt(request.getParameter("proId"));
				String productName = request.getParameter("productName");
				String description = request.getParameter("description");
				double prPrice = Double.parseDouble(request.getParameter("price"));
				String prCategory = request.getParameter("category");
				int pStockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
				String color = request.getParameter("color");
			    int warranty = Integer.parseInt(request.getParameter("warranty"));
				
				isTrue = ProductDBUtil.getInstance().updateProduct(prId, productName, description, prPrice, prCategory, pStockQuantity, color, warranty);
				
				if (isTrue == true) {
					List<Product> productData =ProductDBUtil.getInstance().getProductDetails(prId);
					request.setAttribute("productData", productData);
		            RequestDispatcher dis = request.getRequestDispatcher("admin_product.jsp");
		            dis.forward(request, response);
		        } else {
		            RequestDispatcher dis2 = request.getRequestDispatcher("unsucess.jsp");
		            dis2.forward(request, response);
		        }
	}

}
