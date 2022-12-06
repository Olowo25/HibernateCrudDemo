package com.kambok.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kambok.dao.BaseDao;
import com.kambok.dao.BaseDaoImpl;
import com.kambok.pojo.User;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.sendRedirect("update.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String usrname=request.getParameter("username");
		
		if(usrname!=null) {
		User us=new User();
		us.setPassword(request.getParameter("password"));
		
		BaseDao bd=new BaseDaoImpl();
		 String msg= bd.updateUser(us, usrname);
		
		  request.setAttribute("msg", msg);
		  request.getRequestDispatcher("home.jsp").include(request, response);
		}
	}

}
