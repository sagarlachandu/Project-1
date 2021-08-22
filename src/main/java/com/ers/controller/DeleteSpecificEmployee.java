package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.entity.SignupEntity;
import com.ers.service.SignupService;
import com.ers.service.SignupServiceImpl;

/**
 * Servlet implementation class DeleteSpecificEmployee
 */
public class DeleteSpecificEmployee extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie[] c = request.getCookies();
		String userName = c[0].getValue();
		out.println("<body>");
		out.println("<center>");
		out.println("<marquee><h1>Welcome" + " " + userName + "</H1></marquee>");
		SignupEntity signupEntity=new SignupEntity();
		SignupService signupServiceImpl=new SignupServiceImpl();
		List<String> userIdList=signupServiceImpl.getUserNames();
		for(String idList:userIdList)
		{
			System.out.println(idList);
		}
		out.println("<center>");
		out.println("<H1>Delete Specific Employee</H1>");
		out.println("<form action='http://localhost:8080/EmployeeReimbursementApp/DeleteSpecificUser' method='GET'>");
		out.println("Employees UserName:<select name='userName'>");
		for(String userNameList:userIdList)
		{
			out.println("<option name='id'>"+userNameList+"");
		}
		out.println("<select><br>");
		out.println("<input type='submit' value='Select the Employee'>");
		out.println("</form>");
		out.println("</center>");
	}

}