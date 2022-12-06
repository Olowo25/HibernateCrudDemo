package com.kambok.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kambok.dao.BaseDao;
import com.kambok.dao.BaseDaoImpl;
import com.kambok.pojo.AppointDetails;
import com.kambok.pojo.User;


public class Appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("appointment.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String msg = "Password and Conform Passwords must be same";
		  String page = "appointment.jsp";
		
		    AppointDetails ap=new AppointDetails();
		   ap.setFirstname(request.getParameter("firstname"));
		   ap.setLastname (request.getParameter("lastname"));
		
		
		   //System.out.println(user.toString());
		   BaseDao baseDao = new BaseDaoImpl();
		   msg = baseDao.appointment(ap);
		   page = "login.jsp";
		
		  request.setAttribute("msg2", msg);
		  request.getRequestDispatcher(page).include(request, response);
		 }
	}

