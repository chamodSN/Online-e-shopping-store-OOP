package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user;
import model.userDBUtil;


@WebServlet("/deleteUserServlet")
public class deleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean isTrue;
		
		String id = request.getParameter("userId");
		String uName = request.getParameter("userName");
		
		isTrue = userDBUtil.deleteUser(id);
		
		if(isTrue==true) {
			RequestDispatcher dis = request.getRequestDispatcher("createAccount.jsp");
			dis.forward(request, response);
		}else {
			List<user> userDetails = userDBUtil.getUserDetails(uName);
			request.setAttribute("userDetails", userDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("userAccount.jsp");
			dis2.forward(request, response);
		}
		
		
		
	}

}
