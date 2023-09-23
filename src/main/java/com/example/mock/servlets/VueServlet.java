package com.example.mock.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/vuePlaceholder")
public class VueServlet extends HttpServlet{

	private static final long serialVersionUID = 28795294541374444L;

	@Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws IOException, ServletException {
		
		request.getRequestDispatcher("/WEB-INF/views/vuePlaceholder.jsp").forward(request,response);
	}
	
}
