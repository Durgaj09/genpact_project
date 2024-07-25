package com.bank.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.DAO.customerDAO;
import com.bank.Model.Customer;

/**
 * Servlet implementation class AdminViewDelete
 */
@WebServlet("/AdminViewDelete")
public class AdminViewDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
			
			HttpSession session=request.getSession();
			session.setAttribute("accno",accno);
			session.setAttribute("name", name);
			session.setAttribute("add", add);
			session.setAttribute("phno", phno);
			session.setAttribute("email", email);
			session.setAttribute("accty", accty);
			session.setAttribute("bal", bal);
			session.setAttribute("dob", dob);
			session.setAttribute("idp", idp);
			session.setAttribute("idn", idn);
			
			response.sendRedirect("confirmDelete.jsp");
			}
			else {
				response.sendRedirect("NotPresent.html");
			}
			
		}catch(ClassNotFoundException e) {
			throw new ServletException(e);
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