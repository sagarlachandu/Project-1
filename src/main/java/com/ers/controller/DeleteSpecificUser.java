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
import com.ers.model.Signup;
import com.ers.service.SignupService;
import com.ers.service.SignupServiceImpl;

/**
 * Servlet implementation class DeleteSpecificUser
 */
public class DeleteSpecificUser extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean getStatus=false;
		String userName=request.getParameter("userName");
		SignupService signupServiceImpl=new SignupServiceImpl();
		List<SignupEntity> employeeDetailsList=signupServiceImpl.getEmployeeDetails(userName);
		Signup signup=new Signup();
		for(SignupEntity empList: employeeDetailsList)
		{
			signup.setFirstName(empList.getFirstName());
			signup.setLastName(empList.getLastName());
			signup.setDateOfBirth(empList.getDateOfBirth());
			signup.setAge(empList.getAge());
			signup.setGender(empList.getGender());
			signup.setEmail(empList.getEmail());
			signup.setContactNo(empList.getContactNo());
			signup.setAddress(empList.getAddress());
			signup.setEmployeeType(empList.getEmployeeType());
		}
		String empType=signup.getEmployeeType();
		System.out.println(empType);
		getStatus=signupServiceImpl.deleteEmployeeDetails(signup);
		System.out.println(getStatus);
		if(getStatus)
		{
			response.sendRedirect("Manager.jsp");
		}
	}

}