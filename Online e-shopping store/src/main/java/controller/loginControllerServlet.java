package controller;

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

import model.user;
import model.userDBUtil;

@WebServlet("/loginControllerServlet")
public class loginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String userName = request.getParameter("loginUserName");
		String password = request.getParameter("loginPassword");
		boolean isTrue;

		try {

			HttpSession session = request.getSession();

			isTrue = userDBUtil.validate(userName, password);

			if ("sandun dulanjana".equals(userName) && "Sandun@321".equals(password)) {
				List<user> userDetails = userDBUtil.getUserDetails(userName);

				request.setAttribute("userDetails", userDetails);

				session.setAttribute("userSessions", userDetails);

				user loggedInUser = userDetails.get(0);
				session.setAttribute("user_id", loggedInUser.getUser_id());
				session.setAttribute("userName", loggedInUser.getUserName());

				RequestDispatcher dis = request.getRequestDispatcher("insertProduct.jsp");
				dis.forward(request, response);
			}

			if (isTrue == true) {
				List<user> userDetails = userDBUtil.getUserDetails(userName);

				request.setAttribute("userDetails", userDetails);

				session.setAttribute("userSessions", userDetails);

				user loggedInUser = userDetails.get(0);
				session.setAttribute("user_id", loggedInUser.getUser_id());
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
