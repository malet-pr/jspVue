package com.example.mock.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mvcPlaceholder")
public class MvcServlet extends HttpServlet{

	private static final long serialVersionUID = -7244062769210574539L;

	@Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws IOException, ServletException {
		
		request.getRequestDispatcher("/WEB-INF/views/mvcPlaceholder.jsp").forward(request,response);
	}
}
