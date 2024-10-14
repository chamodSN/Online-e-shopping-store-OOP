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

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		        boolean isTrue;
		        //ProductDBUtil pDBU = new ProductDBUtil();
				
				int productId = Integer.parseInt(request.getParameter("proId"));
				isTrue = ProductDBUtil.getInstance().deleteProductDetails(productId);
				
				if (isTrue == true) {
					
		            RequestDispatcher dis = request.getRequestDispatcher("insertProduct.jsp");
		            dis.forward(request, response);
		        } else {
		        	List<Product> productData =ProductDBUtil.getInstance().getProductDetails(productId);
		        	request.setAttribute("productData", productData);
		            RequestDispatcher dis2 = request.getRequestDispatcher("admin_product.jsp");
		            dis2.forward(request, response);
		        }
				
			}
}
