package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.product;
import model.productDBUtil;


@WebServlet("/deleteProductServlet")
public class deleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        boolean isTrue;
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		isTrue = productDBUtil.deleteProductDetails(productId);
		
		if (isTrue == true) {
			
            RequestDispatcher dis = request.getRequestDispatcher("insertProduct.jsp");
            dis.forward(request, response);
        } else {
        	List<product> productData =productDBUtil.getProductDetails(productId);
        	request.setAttribute("productData", productData);
            RequestDispatcher dis2 = request.getRequestDispatcher("admin_product.jsp");
            dis2.forward(request, response);
        }
		
	}

}
