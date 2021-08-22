package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ers.model.Signup;
import com.ers.service.SignupService;
import com.ers.service.SignupServiceImpl;

public class SignupServlet extends HttpServlet {
	static List<Signup> empList = new ArrayList<Signup>();
	static Logger logger=Logger.getLogger("SignupServlet.class");
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		logger.info("In sign up -> add method");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dateOfBirth = request.getParameter("dateOfBirth");
		String age = request.getParameter("age");
		String gender = request.getParameter("radioGender");
		String email = request.getParameter("email");
		String contactNo = request.getParameter("contactNo");
		String address = request.getParameter("address");
		String employeeType = request.getParameter("etype");
		//Cookie cookie=new Cookie("employeeType",employeeType);
		//response.addCookie(cookie);
		System.out.println(firstName + " " + lastName + " " + dateOfBirth + " " + age + " " + gender + " " + email + " "
				+ contactNo + " " + address + " " + employeeType);
		Signup signUp = new Signup();
		signUp.setFirstName(firstName);
		signUp.setLastName(lastName);
		signUp.setDateOfBirth(dateOfBirth);
		signUp.setAge(Integer.parseInt(age));
		signUp.setGender(gender);
		signUp.setEmail(email);
		signUp.setContactNo(contactNo);
		signUp.setAddress(address);
		signUp.setEmployeeType(employeeType);
		SignupService signupServiceImpl = new SignupServiceImpl();
		boolean getStatus = signupServiceImpl.addEmployeeDetails(signUp);
		if (getStatus) {
			logger.info("In login credential -> add method");
			response.sendRedirect("http://localhost:8080/EmployeeReimbursementApp/loginCredinitial.html");

		}
	}

}