package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.productDBUtil;


@WebServlet("/addProductServlet")
@MultipartConfig
public class addProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isTrue;
		String productName = request.getParameter("productName");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		String category = request.getParameter("category");
		int stockQuantity = Integer.parseInt(request.getParameter("stockQuantity"));
		Part part = request.getPart("image");
		String image = part.getSubmittedFileName();
		String productColour = request.getParameter("color");
		int prWarranty = Integer.parseInt(request.getParameter("warranty"));
		
		isTrue = productDBUtil.insertProduct(productName, description, price, category, stockQuantity, image, productColour, prWarranty);

		
		if (isTrue == true) {
            RequestDispatcher dis = request.getRequestDispatcher("sucess.jsp");
            dis.forward(request, response);
        } else {
            RequestDispatcher dis2 = request.getRequestDispatcher("unsucess.jsp");
            dis2.forward(request, response);
        }
		
	}

}
