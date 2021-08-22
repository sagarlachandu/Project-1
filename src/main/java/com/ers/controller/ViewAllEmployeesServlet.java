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
 * Servlet implementation class ViewAllEmployeesServlet
 */
public class ViewAllEmployeesServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie[] c = request.getCookies();
		String userName = c[0].getValue();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Welcome" + " " + userName + "</h1>");
		SignupService signupServiceImpl = new SignupServiceImpl();
		List<SignupEntity> allEmployeesList = signupServiceImpl.getAllEmployees();
		for (SignupEntity re : allEmployeesList) {
			System.out.println(re.getFirstName());
			System.out.println(re.getLastName());
			System.out.println(re.getDateOfBirth());
			System.out.println(re.getAge());
			System.out.println(re.getGender());
			System.out.println(re.getEmail());
			System.out.println(re.getAddress());
			System.out.println(re.getEmployeeType());
		}
		out.println("<table border='2'>");
		out.println("<caption><h4>All Employee Details</h4></caption>");
		out.println("<tr>");
		out.println("<th>First Name</th>");
		out.println("<th>Last Name</th>");
		out.println("<th>Date of Birth</th>");
		out.println("<th>Age</th>");
		out.println("<th>Gender</th>");
		out.println("<th>Email</th>");
		out.println("<th>Address</th>");
		out.println("<th>Employee Type</th>");
		out.println("</tr>");
		for (SignupEntity re : allEmployeesList) {
			out.println("<tr>");
			out.println("<td>" + re.getFirstName() + "</td>");
			out.println("<td>" + re.getLastName() + "</td>");
			out.println("<td>" + re.getDateOfBirth() + "</td>");
			out.println("<td>" + re.getAge() + "</td>");
			out.println("<td>" + re.getGender() + "</td>");
			out.println("<td>" + re.getEmail() + "</td>");
			out.println("<td>" + re.getAddress() + "</td>");
			out.println("<td>" + re.getEmployeeType() + "</td>");
			out.println("</tr");
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("<a href='Manager.jsp'><input type='submit' value='Go To Home Page'></a>");
		out.println("</center>");
		out.println("</body>");

	}

}