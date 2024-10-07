package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.userDBUtil;

@WebServlet("/registerControllerServlet")
@MultipartConfig
public class registerControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		boolean isTrue;
		
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Part part = request.getPart("image");
		String imageUrl = part.getSubmittedFileName();
		
		isTrue = userDBUtil.insertUser(userName,password, email, imageUrl);
		
		if(isTrue==true) {
			out.println("<script type='text/javascript'>");
			out.println("alert('User Account Created Sucessfully');");
			out.println("location='login.jsp'");
			out.println("</script>");
		}else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Failed Creating User Account');");
			out.println("location='login.jsp'");
			out.println("</script>");
		}
	}

}
