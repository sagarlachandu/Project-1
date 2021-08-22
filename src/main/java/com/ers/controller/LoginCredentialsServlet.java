package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.LoginCredentials;
import com.ers.model.Signup;
import com.ers.service.LoginCredentialsService;
import com.ers.service.LoginCredentialsServiceImpl;
import static com.ers.controller.SignupServlet.empList;
/**
 * Servlet implementation class LoginCredentialsServlet
 */
public class LoginCredentialsServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("uname");
		String passWord = request.getParameter("pwd");
		String confirmPassword = request.getParameter("confirmPassword");
		boolean status=false;
		System.out.println(userName + " " + passWord + " " + confirmPassword);
		if (passWord.equals(confirmPassword)) {
			LoginCredentials loginCredentials = new LoginCredentials();
			loginCredentials.setUserName(userName);
			loginCredentials.setPassWord(passWord);
			LoginCredentialsService loginCredentialsServiceImpl = new LoginCredentialsServiceImpl();
			status=loginCredentialsServiceImpl.addLoginCredentials(loginCredentials);
			if(status)
			{
				response.sendRedirect("http://localhost:8080/EmployeeReimbursementApp/SuccessRegistration.html");
			}
		}
		else
		{
			out.println("<center>");
			out.println("<h1>Password and confirm password not same></h1>");
			out.println("<a href='http://localhost:8080/EmployeeReimbursementApp/loginCredinitial.html'><input type='submit' value='Go Back'></a>");
			out.println("</center>");
		}
	}
}