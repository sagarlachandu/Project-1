package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.service.ReimbursementRequestService;
import com.ers.service.ReimbursementRequestServiceImpl;

/**
 * Servlet implementation class ManagerUpdateRequestServlet
 */
public class ManagerUpdateRequestServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean getStatus = false;
		String managerAction = "";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie c[] = request.getCookies();
		String userName = c[0].getValue();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Welcome" + " " + userName + "</h1>");
		String requestId = request.getParameter("reqId");
		String action = request.getParameter("managerAction");
		String reqActionDate=request.getParameter("reqActionDate");
		String reqActionRemarks=request.getParameter("reqActionRemarks");
		if (action.equals("Approve")) {
			managerAction = "Accepted";
		} else {
			managerAction = "Denied";
		}
		System.out.println(requestId + " " + managerAction+" "+reqActionDate+" "+reqActionRemarks);
		ReimbursementRequestService reimbursementRequestServiceImpl = new ReimbursementRequestServiceImpl();
		getStatus = reimbursementRequestServiceImpl.updateRequestStatus(requestId, managerAction,reqActionDate,reqActionRemarks);
		System.out.println(getStatus);
		if(getStatus)
		{
			out.println("<center>");
			out.println("<h1>You Reviewed and Updated the status of the Reimbursement Request!</h1>");
			out.println("<a href='Manager.jsp'><input type='submit' value='Go To Home Page'></a>");
			out.println("</center>");
		}
	}
}