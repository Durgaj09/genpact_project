package com.bank.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.DAO.customerDAO;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accno=request.getParameter("accno");
		int opass=Integer.parseInt(request.getParameter("opass"));
		int npass=Integer.parseInt(request.getParameter("npass"));
		int cpass=Integer.parseInt(request.getParameter("cpass"));
		System.out.println(accno+" "+opass+" "+" "+npass+" "+cpass);
		
		customerDAO cdao=new customerDAO();
		String r=cdao.updatePassword(accno,opass,npass,cpass);
		switch(r) {
		case "success":
			request.setAttribute("accno",accno);
			RequestDispatcher rd=request.getRequestDispatcher("ResetSuccessfull.html");
			rd.forward(request,response);
			break;
		case "old":
			response.sendRedirect("Reset.html");
			break;
		case "con":
			response.sendRedirect("Reset.html");
			break;
		case "failed":
			response.sendRedirect("Error.html");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}