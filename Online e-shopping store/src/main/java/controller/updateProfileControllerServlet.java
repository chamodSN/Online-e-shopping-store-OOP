package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.userDBUtil;


@WebServlet("/updateProfileControllerServlet")
public class updateProfileControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		
		boolean isTrue;
		
		isTrue = userDBUtil.updateUser(id, userName, password, email, role);
		
		if(isTrue==true) {
			RequestDispatcher dis = request.getRequestDispatcher("sucess.jsp");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsucess.jsp");
			dis2.forward(request, response);
		}
	}

}
