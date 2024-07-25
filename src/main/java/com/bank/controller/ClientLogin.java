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
 * Servlet implementation class ClientLogin
 */
@WebServlet("/ClientLogin")
public class ClientLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		int pin=Integer.parseInt(request.getParameter("pass"));
		
		Customer cus=new Customer();
		cus.setName(uname);
		cus.setPin(pin);
		
		customerDAO cdao=new customerDAO();
		ResultSet rs=null;
		try {
			rs=cdao.customerVerify(cus);
			if(rs.next()) {
				String accno=rs.getString(1);
				request.setAttribute("name", uname);
				request.setAttribute("accno", accno);
				RequestDispatcher rd=request.getRequestDispatcher("CustomerAction.jsp");
				rd.forward(request, response);
			}
			else {
				response.sendRedirect("login_Client.html");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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