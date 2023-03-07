package com.app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")//endpoint for this sevlet.
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//below method will process the get request
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("simple response for the browser");
	}
	
	//below method will process the post request.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		response.getWriter().append(name+"--"+address);
	}

}
