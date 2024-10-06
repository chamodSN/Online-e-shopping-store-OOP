package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user;
import model.userDBUtil;


@WebServlet("/updateProfileControllerServlet")
public class updateProfileControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		boolean isTrue;
		
		isTrue = userDBUtil.updateUser(id, userName, password, email);
		
		if(isTrue==true) {
			
			HttpSession session = request.getSession();
			
		    List<user> userDetails = userDBUtil.getUserDetails(userName);
			
			request.setAttribute("userDetails", userDetails);
			
			session.setAttribute("userSessions", userDetails);
		    response.sendRedirect("userAccount.jsp");
		    
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsucess.jsp");
			dis2.forward(request, response);
		}
	}

}