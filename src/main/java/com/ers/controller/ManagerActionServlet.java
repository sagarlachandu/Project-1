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
import com.ers.service.ReimbursementRequestService;
import com.ers.service.ReimbursementRequestServiceImpl;
import com.ers.service.SignupService;
import com.ers.service.SignupServiceImpl;


/**
 * Servlet implementation class ManagerActionServlet
 */
public class ManagerActionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie c[]=request.getCookies();
		String userName=c[0].getValue();
		out.println("<body>");
		out.println("<center>");
		out.println("<marquee><h1>Welcome" + " " + userName + "</H1></marquee>");
		ReimbursementRequestService reimbursementRequestServiceImpl=new ReimbursementRequestServiceImpl();
		List<String> requestIdList=reimbursementRequestServiceImpl.getRequestIds();
		for(String idList:requestIdList)
		{
			System.out.println(idList);
		}
		out.println("<center>");
		out.println("<H1>Approve or Deny Request</H1>");
		out.println("<form action='http://localhost:8080/EmployeeReimbursementApp/ManagerViewServlet' method='GET'>");
		out.println("Reimbursement Request IDs:<select name='reqId'>");
		for(String idList:requestIdList)
		{
			out.println("<option name='id'>"+idList+"");
		}
		out.println("<select><br>");
		out.println("<input type='submit' value='Select the Request ID'>");
		out.println("</form>");
		out.println("</center>");
	}

}