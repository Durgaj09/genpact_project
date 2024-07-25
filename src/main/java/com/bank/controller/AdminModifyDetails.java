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
 * Servlet implementation class Admin
 */
@WebServlet("/AdminModifyDetails")
public class AdminModifyDetails extends HttpServlet {
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
		String name=request.getParameter("name");
		String add=request.getParameter("add");
		String email=request.getParameter("email");
		String phno=request.getParameter("phno");
		String accty=request.getParameter("accty");
		long bal=Long.parseLong(request.getParameter("bal"));
		String dob=request.getParameter("dob");
		String idp=request.getParameter("idp");
		String idn=request.getParameter("idn");
		System.out.println(dob);
		
		Customer cus=new Customer();
		cus.setAccount_Number(accno);
		cus.setName(name);
		cus.setAddress(add);
		cus.setEmail_id(email);
		cus.setMobile_no(phno);
		cus.setAccount_type(accty);
		cus.setInitial_balance(bal);
		cus.setDate_of_Birth(dob);
		cus.setId_proof(idp);
		cus.setId_number(idn);
		
		customerDAO cdao=new customerDAO();
		ResultSet rs=null;
		try {
			int result=cdao.ModifyDetails(cus);
			if(result>0) {
				rs=cdao.ViewDetails(cus);
				if(rs.next()) {
					name=rs.getString(1);
					add=rs.getString(2);
					phno=rs.getString(3);
					email=rs.getString(4);
					accty=rs.getString(5);
					bal=rs.getLong(6);
					dob=rs.getString(7);
					idp=rs.getString(8);
					idn=rs.getString(9);
					
					request.setAttribute("accno", accno);
					request.setAttribute("name", name);
					request.setAttribute("add", add);
					request.setAttribute("phno", phno);
					request.setAttribute("email", email);
					request.setAttribute("accty", accty);
					request.setAttribute("bal", bal);
					request.setAttribute("dob", dob);
					request.setAttribute("idp", idp);
					request.setAttribute("idn", idn);
					RequestDispatcher rd=request.getRequestDispatcher("modifiedDetails.jsp");
					rd.forward(request,response);
				}
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