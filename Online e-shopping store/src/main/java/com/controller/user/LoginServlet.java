package com.controller.user;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.entities.User;
import com.model.utils.UserDBUtil;
import com.services.UserServicesDBUtil;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String userName = request.getParameter("loginUserName");
		String password = request.getParameter("loginPassword");
		System.out.println(userName);
		System.out.println(password);
		boolean isTrue;

		try {

			HttpSession session = request.getSession();

			isTrue = UserServicesDBUtil.validate(userName, password);
			
			System.out.println(isTrue);
			
			//UserDBUtil uDBUtil = new UserDBUtil();

			if ("sandun dulanjana".equals(userName) && "Sandun@321".equals(password)) {
				List<User> userDetails = UserDBUtil.getInstance().getUserDetails(userName);

				request.setAttribute("userDetails", userDetails);

				session.setAttribute("userSessions", userDetails);

				User loggedInUser = userDetails.get(0);
				session.setAttribute("userId", loggedInUser.getUserId());
				session.setAttribute("userName", loggedInUser.getUserName());

				RequestDispatcher dis = request.getRequestDispatcher("insertProduct.jsp");
				dis.forward(request, response);
			}

			if (isTrue == true) {
				List<User> userDetails = UserDBUtil.getInstance().getUserDetails(userName);

				request.setAttribute("userDetails", userDetails);

				session.setAttribute("userSessions", userDetails);

				User loggedInUser = userDetails.get(0);
				session.setAttribute("userId", loggedInUser.getUserId());
				session.setAttribute("userName", loggedInUser.getUserName());

				RequestDispatcher dis = request.getRequestDispatcher("userAccount.jsp");
				dis.forward(request, response);

			} else {
				out.println("<script type='text/javascript'>");
				out.println("alert('Your user name or password is incorrect');");
				out.println("location='login.jsp'");
				out.println("</script>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
