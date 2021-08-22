package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.service.LoginService;
import com.ers.service.LoginServiceImpl;

/**
 * Servlet implementation class ForgotPassWordServlet
 */
public class ForgotPassWordServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String passWord = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		boolean getStatus = false;
		System.out.println(userName + " " + passWord + " " + confirmPassword);
		if (!passWord.equals(confirmPassword)) {
			out.println("<center>");
			out.println("<h1>Password and Confirm password not same!</h1>");
			out.println("</center>");
		} else {
			LoginService loginServiceImpl = new LoginServiceImpl();
			getStatus = loginServiceImpl.updateForgotPassword(userName, passWord);
			if (getStatus) {
				response.sendRedirect("http://localhost:8080/EmployeeReimbursementApp/SuccessForgotPassword.html");
			} else {
				response.sendRedirect("http://localhost:8080/EmployeeReimbursementApp/failureforgotpassword.html");
			}
		}
		
	}

}