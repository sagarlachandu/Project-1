package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.entity.ReimbursementRequestEntity;
import com.ers.service.ReimbursementRequestService;
import com.ers.service.ReimbursementRequestServiceImpl;

/**
 * Servlet implementation class ViewSpecificUserRequest
 */
public class ViewSpecificUserRequest extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String userName=request.getParameter("userName");
		out.println("<body>");
		out.println("<center>");
		out.println("<marquee><h1>Welcome"+" "+userName+"</H1></marquee>");
		ReimbursementRequestService reimbursementRequestServiceImpl = (ReimbursementRequestService) new ReimbursementRequestServiceImpl();
		List<ReimbursementRequestEntity> allRequestList =reimbursementRequestServiceImpl.getParticularUserAllRequests(userName);
		for(ReimbursementRequestEntity re : allRequestList)
		{
			System.out.println(re.getReqId());
			System.out.println(userName);
			System.out.println(re.getReqType());
			System.out.println(re.getReqDate());
			System.out.println(re.getReqAmount());
			System.out.println(re.getReqStatus());
			System.out.println(re.getReqDescription());
			System.out.println(re.getReqActionDate());
			System.out.println(re.getReqActionRemarks());
		}
		
		out.println("</select></form>");
		out.println("<table border='2'>");
		out.println("<caption><h4>Employee Requests</h4></caption>");
		out.println("<tr>");
		out.println("<th>Request Id</th>");
		out.println("<th>User Name</th>");
		out.println("<th>Request Type</th>");
		out.println("<th>Request Date</th>");
		out.println("<th>Request Amount</th>");
		out.println("<th>Request Status</th>");
		out.println("<th>Request Description</th>");
		out.println("<th>Request Action Date</th>");
		out.println("<th>Request Action remarks</th>");
		out.println("</tr>");
		for(ReimbursementRequestEntity re : allRequestList)
		{
			out.println("<tr>");
			out.println("<td>"+re.getReqId()+"</td>");
			out.println("<td>"+userName+"</td>");
			out.println("<td>"+re.getReqType()+"</td>");
			out.println("<td>"+re.getReqDate()+"</td>");
			out.println("<td>"+re.getReqAmount()+"</td>");
			out.println("<td>"+re.getReqStatus()+"</td>");
			out.println("<td>"+re.getReqDescription()+"</td>");
			out.println("<td>"+re.getReqActionDate()+"</td>");
			out.println("<td>"+re.getReqActionRemarks()+"</td>");
			out.println("</tr");
		}
		out.println("</tr>");
		out.println("</table>");
		out.println("<a href='Manager.jsp'><input type='submit' value='Go To Home Page'></a>");
		out.println("</center>");
		out.println("</body>");
		
	}

}