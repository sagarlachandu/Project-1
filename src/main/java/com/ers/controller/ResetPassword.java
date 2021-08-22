package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ers.service.LoginService;
import com.ers.service.LoginServiceImpl;

/**
 * Servlet implementation class ResetPassword
 */
public class ResetPassword extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie[] c = request.getCookies();
		String userName = c[0].getValue();
		out.println("<body>");
		out.println("<center>");
		out.println("<marquee><h1>Welcome" + " " + userName + "</H1></marquee>");
		String currentPassWord = request.getParameter("currentPassword");
		String newPassWord = request.getParameter("NewPassword");
		String confirmNewPassword = request.getParameter("reEnterPassword");
		boolean getStatus = false;
		System.out.println(currentPassWord + " " + newPassWord + " " + confirmNewPassword);
		if (!newPassWord.equals(confirmNewPassword)) {
			out.println("<head>");
			out.println("<style>");
			out.println("<link rel='stylesheet' href='boxModel.css'>");
			out.println("</style>");
			out.println("</head>");
			out.println("<body>");
			out.println("<center>");
			out.println("<h1>New Password and Confirm New Password not same!</h1>");
			out.println(
					"<a href='http://localhost:8080/EmployeeReimbursementApp/ResetPassWord.html'><input type='submit' value='Go Back'></a>");
			out.println("</center>");
			out.println("</body>");
		} else {
			LoginService loginServiceImpl = new LoginServiceImpl();
			getStatus = loginServiceImpl.resetForgotPassword(userName, newPassWord, currentPassWord);
		}
		System.out.println(getStatus);
		if (getStatus) {
			response.sendRedirect("http://localhost:8080/EmployeeReimbursementApp/SuccessResetPassword.html");
		} else {
			response.sendRedirect("http://localhost:8080/EmployeeReimbursementApp/FailureResetPassword.html");
		}
	
	}

}