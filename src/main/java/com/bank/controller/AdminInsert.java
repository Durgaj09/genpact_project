package com.bank.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.DAO.customerDAO;
import com.bank.Model.Customer;

/**
 * Servlet implementation class AdminOperation
 */
@WebServlet("/AdminInsert")
public class AdminInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
private long accnogenerator() throws ClassNotFoundException, SQLException {
		
		Random random=new Random();
		long f=0;
		for(int i=0;i<15;i++) {
			int digit=random.nextInt(10);
			f=f*10+digit;
		}
		customerDAO cdao=new customerDAO();
		List<Long> arr=new ArrayList<>();
    	Connection con=cdao.connection();
    	PreparedStatement ps = con.prepareStatement("Select Account_Number from customerdetails");
    	ResultSet rs=ps.executeQuery();
    	while(rs.next()) {
    		arr.add(rs.getLong(1));
    	}
    	if(!arr.contains(f)) {
    		return f;
    	}
    	else {
    		return accnogenerator();
    	}
		
		
		
	}
    private int pingenerator() {
    	int n=0;
    	Random random=new Random();
    	for(int i=0;i<4;i++) {
    		int digit=random.nextInt(1,10);
    		n=n*10+digit;
    	}
    	return n;
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accno="";
		try {
			accno = Long.toString(accnogenerator());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pin=pingenerator();
		String name=request.getParameter("name");
		String add=request.getParameter("address");
		String phno=request.getParameter("phno");
		String email=request.getParameter("email");
		String dob=request.getParameter("DOB");
		String idp=request.getParameter("idproof");
		String idn=request.getParameter("idnumber");
		String accty=request.getParameter("account");
		long bal=Long.parseLong(request.getParameter("balance"));
		
	
		
		Customer cus=new Customer();
		cus.setAccount_Number(accno);
		cus.setMobile_no(phno);
		cus.setAccount_type(accty);
		cus.setName(name);
		cus.setPin(pin);
		cus.setId_number(idn);
		cus.setId_proof(idp);
		cus.setEmail_id(email);
		cus.setDate_of_Birth(dob);
		cus.setInitial_balance(bal);
		cus.setAddress(add);
		
		
		HttpSession session=request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("accno", accno);
		session.setAttribute("pin", pin);
		
		customerDAO cdao=new customerDAO();
		boolean is=false;
		try {
			is=cdao.Insert(cus);
			if(is==true)
			response.sendRedirect("login_details.jsp");
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