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
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accno=request.getParameter("accno");
		System.out.println(accno);
		
		Customer cus=new Customer();
		cus.setAccount_Number(accno);
		
		customerDAO cdao=new customerDAO();
		ResultSet rs=null;
		try {
			rs=cdao.ViewDetails(cus);
			System.out.println("before if");
			if(rs.next()) {
				String name=rs.getString(1);
				String add=rs.getString(2);
				String phno=rs.getString(3);
				String email=rs.getString(4);
				String accty=rs.getString(5);
				String dob=rs.getString(7);
				String idp=rs.getString(8);
				String idn=rs.getString(9);
				
				request.setAttribute("accno", accno);
				request.setAttribute("name", name);
				request.setAttribute("add", add);
				request.setAttribute("phno",phno);
				request.setAttribute("email", email);
				request.setAttribute("accty", accty);
				request.setAttribute("dob", dob);
				request.setAttribute("idp", idp);
				request.setAttribute("idn", idn);
				System.out.println("try");
				RequestDispatcher rd=request.getRequestDispatcher("Profile.jsp");
				rd.forward(request, response);
				System.out.println("try");
				
			}
			else {
				System.out.println("else");
			}
		}catch(ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("catch c");
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("catch s");
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