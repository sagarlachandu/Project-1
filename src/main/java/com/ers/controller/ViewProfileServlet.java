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
 * Servlet implementation class ViewProfileServlet
 */
public class ViewProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] c=request.getCookies();
		String userName=c[0].getValue();
		out.println("<head>\r\n"
				+ "        <title>Logout</title>\r\n"
				+ "        <style>\r\n"
				+ "body {\r\n"
				+ "}\r\n"
				+ "</style>\r\n"
				+ "        \r\n"
				+ "    </head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<marquee><h1>Welcome"+" "+userName+"</H1></marquee>");
		SignupService signupServiceImpl=new SignupServiceImpl();
		List<SignupEntity> employeeList=signupServiceImpl.getEmployeeDetails(userName);
		for(SignupEntity elist : employeeList)
		{
			System.out.println(elist.getFirstName());
			System.out.println(elist.getLastName());
			System.out.println(elist.getDateOfBirth());
			System.out.println(elist.getAge());
			System.out.println(elist.getGender());
			System.out.println(userName);
			System.out.println(elist.getContactNo());
			System.out.println(elist.getAddress());
			System.out.println(elist.getEmployeeType());
		}
		out.println("<table border='2'>");
		out.println("<caption><h4>Personal Information</h4></caption>");
		for(SignupEntity elist : employeeList)
		{
			out.println("<tr>");
			out.println("<th>First name</th>");
			out.println("<td>"+elist.getFirstName()+"</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Last name</th>");
			out.println("<td>"+elist.getLastName()+"</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Date of Birth</th>");
			out.println("<td>"+elist.getDateOfBirth()+"</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Age</th>");
			out.println("<td>"+elist.getAge()+"</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Gender</th>");
			out.println("<td>"+elist.getGender()+"</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Email</th>");
			out.println("<td>"+userName+"</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Contact Number</th>");
			out.println("<td>"+elist.getContactNo()+"</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Address</th>");
			out.println("<td>"+elist.getAddress()+"</td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<th>Employee Type</th>");
			out.println("<td>"+elist.getEmployeeType()+"</td>");
			out.println("</tr");
			if(elist.getEmployeeType().equals("Employee"))
			{
				out.println("<tr>");
				out.println("<center>");
				out.println("<td><center><a href='Employee.jsp'><input id='submitButton' type='submit' value='Go Back to Home'></center></a>");
				out.println("</td>");
				out.println("</center>");
				out.println("</tr>");
			}
			if(elist.getEmployeeType().equals("Manager"))
			{
				out.println("<tr>");
				out.println("<center>");
				out.println("<td><center><a href='Manager.jsp'><input id='submitButton' type='submit' value='Go Back to Home'></center></a>");
				out.println("</td>");
				out.println("</center>");
				out.println("</tr>");
			}
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
	
	}

}