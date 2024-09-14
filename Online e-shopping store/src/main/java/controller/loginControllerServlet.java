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


@WebServlet("/loginControllerServlet")
public class loginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("loginUserName");
		String password = request.getParameter("loginPassword");
		
		try {
			List<user> userDetails = userDBUtil.validate(userName, password);
			
			request.setAttribute("userDetails", userDetails);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dis = request.getRequestDispatcher("userAccount.jsp");
		dis.forward(request, response);
	}

}
