package com.example.mock.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/time")
public class DateServlet extends HttpServlet {

private static final long serialVersionUID = 9055283262774271898L;

@Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
	
	int days = Integer.valueOf(request.getParameter("days"));
    
    Calendar cal = Calendar.getInstance();  
    
    Date now = cal.getTime();
    cal.add(Calendar.DATE,days);
    
    SimpleDateFormat date1Format = new SimpleDateFormat("kk:mm 'on' EEEE MMMM dd ', 'yyyy", Locale.ENGLISH);
    String formattedDate = date1Format.format(now);
    SimpleDateFormat date2Format = new SimpleDateFormat("EEEE 'on' MMMM  dd ', ' yyyy", Locale.ENGLISH);
    String newFormatedDate = date2Format.format(cal.getTime());
    
    request.setAttribute("today", formattedDate);
    request.setAttribute("otherDate", newFormatedDate);
    if(days != 0) {
    	request.setAttribute("sentence", days > 0 ? "In "+days+" days will be " : -days+" days ago was ");
    } else {
    	request.setAttribute("sentence", "You added 0 days, therefore it's still ");
    }
    
    request.getRequestDispatcher("/WEB-INF/views/today.jsp").forward(request,response);
  }
}

