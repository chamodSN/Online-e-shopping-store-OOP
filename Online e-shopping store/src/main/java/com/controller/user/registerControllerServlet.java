package com.controller.user;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.model.utils.UserDBUtil;

@WebServlet("/RegisterControllerServlet")
@MultipartConfig
public class RegisterControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				
				boolean isTrue;
				//UserDBUtil uDBUtil = new UserDBUtil();
				
				String userName = request.getParameter("userName");
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				Part part = request.getPart("image");
				String imageUrl = part.getSubmittedFileName();
					
				isTrue = UserDBUtil.getInstance().insertUser(userName,password, email, imageUrl);
				
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
