package com.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private String email = "admin@gmail.com";
	private String password = "admin";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
		String email = request.getParameter("email");//coming from the http request
		String password = request.getParameter("password");//coming from the http requst.
		if(email.equals(this.email) && password.equals(this.password)) {
			response.getWriter().append("you are correct");
		}else {
			response.getWriter().append("you are wrong.please provide the correct details.");
		}
	}

}
