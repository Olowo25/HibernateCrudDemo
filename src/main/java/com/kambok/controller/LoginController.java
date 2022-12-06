package com.kambok.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kambok.service.BaseService;
import com.kambok.service.BaseServiceImpl;



/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
 private static final long serialVersionUID = 1L;


 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	 response.sendRedirect("login.jsp");
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String username = request.getParameter("username");
  String password = request.getParameter("password");

  HttpSession hs=request.getSession();
  System.out.println(username + " :: " + password);
  String page = "login.jsp";
  if(username.trim().length() >= 0 && username != null &&
    password.trim().length() >= 0 && password != null) {
	
   BaseService loginService = new BaseServiceImpl();
   boolean flag = loginService.login(username, password);
   if(flag) {
    System.out.println("Login success!!!");
    hs.setAttribute("username", username);
    hs.setAttribute("msg", loginService.getposition(username));
    response.sendRedirect("home.jsp");

   } else {
    request.setAttribute("msg", "Wrong Username or Password, Try again!!!");
    request.getRequestDispatcher("login.jsp").include(request, response);
   }
  } else {
   request.setAttribute("msg", "Please enter username and password...");
   request.getRequestDispatcher("login.jsp").include(request, response);
  }
  //request.getRequestDispatcher(page).include(request, response);
 }
}
