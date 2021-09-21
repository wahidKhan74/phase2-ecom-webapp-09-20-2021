package com.simplilearn.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// response.sendRedirect("login.html");
		request.getRequestDispatcher("index.html").include(request, response);
		request.getRequestDispatcher("login.html").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request params
		String userEmail = request.getParameter("useremail");
		String userPassword = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		if(userEmail.equals("") && userPassword.equals("")) {
			out.println("<h1 style='color:red'>Login Failed  * Required filled are missing! </h1>");
		} else {
			if(userEmail.equals("admin@gmail.com") && userPassword.equals("admin@123")) {
				// out.println("<h1 style='color:green'>Login sucessfull ! for user '"+userEmail+"' </h1>");
				request.getRequestDispatcher("index.html").include(request, response);
				request.getRequestDispatcher("login.html").include(request, response);
				request.getRequestDispatcher("success.html").include(request, response);
			} else {
				out.println("<h1 style='color:red'>Login Failed * Invalid credntials </h1>");
			}
		}
		
	}

}
