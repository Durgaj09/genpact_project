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
import com.bank.Model.Customer;

/**
 * Servlet implementation class AdminEditDetails
 */
@WebServlet("/AdminEditDetails")
public class AdminEditDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accno=request.getParameter("accno");
		
		Customer cus=new Customer();
		cus.setAccount_Number(accno);
		
		customerDAO cdao=new customerDAO();
		ResultSet rs=null;
		try {
			rs=cdao.ViewDetails(cus);
			if(rs.next()) {
				String name=rs.getString(1);
				String add=rs.getString(2);
				String phno=rs.getString(3);
				String email=rs.getString(4);
				String accty=rs.getString(5);
				long bal=rs.getLong(6);
				String dob=rs.getString(7);
				String idp=rs.getString(8);
				String idn=rs.getString(9);
				
				request.setAttribute("accno",accno);
				request.setAttribute("name",name);
				request.setAttribute("add",add);
				request.setAttribute("phno",phno);
				request.setAttribute("email",email);
				request.setAttribute("accty",accty);
				request.setAttribute("bal",bal);
				request.setAttribute("dob",dob);
				request.setAttribute("idp",idp);
				request.setAttribute("idn",idn);
				RequestDispatcher rd=request.getRequestDispatcher("modify.jsp");
				rd.forward(request,response);
			}
		}catch(ClassNotFoundException e) {
			throw new ServletException("Class not found...",e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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