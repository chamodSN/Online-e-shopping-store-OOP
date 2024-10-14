package com.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.entities.User;
import com.model.utils.UserDBUtil;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				
				boolean isTrue;
				//UserDBUtil uDBUtil = new UserDBUtil();
				
				String id = request.getParameter("userId");
				String uName = request.getParameter("userName");
				
				isTrue = UserDBUtil.getInstance().deleteUser(id);
				
				if(isTrue==true) {
					RequestDispatcher dis = request.getRequestDispatcher("createAccount.jsp");
					dis.forward(request, response);
				}else {
					List<User> userDetails = UserDBUtil.getInstance().getUserDetails(uName);
					request.setAttribute("userDetails", userDetails);
					
					RequestDispatcher dis2 = request.getRequestDispatcher("userAccount.jsp");
					dis2.forward(request, response);
				}
				
				
				
			}


}
