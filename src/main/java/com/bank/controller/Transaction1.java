package com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.DAO.customerDAO;
import com.bank.Model.Transaction;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction1")
public class Transaction1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transaction1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String desc=request.getParameter("desc");
		String accno=request.getParameter("accno");
		
		int amt=Integer.parseInt(request.getParameter("amount"));
		System.out.println(accno);
		
		customerDAO cdao=new customerDAO();
		String type=request.getParameter("msg");
		if(type.equals("credit")) {
			
			Transaction ts1=new Transaction(desc,0,amt,cdao.getBalance(accno));
			if(cdao.credit(accno, ts1)) {
				request.setAttribute("accno", accno);
				RequestDispatcher rd=request.getRequestDispatcher("CustomerAction.jsp");
				rd.forward(request, response);
			}
			else {
				response.sendRedirect("Error.jsp?msg=error");
			}
		}
		if(type.equals("debit")) {
			Transaction ts2=new Transaction(desc,amt,0,cdao.getBalance(accno));
			switch(cdao.withdraw(accno, ts2)) {
			case "success":
				request.setAttribute("accno", accno);
				RequestDispatcher rd=request.getRequestDispatcher("CustomerAction.jsp");
				rd.forward(request, response);
				break;
			case "high":
				response.sendRedirect("Debit.jsp?msg=high");
				break;
			case "zero":
				response.sendRedirect("CustomerAction.jsp?msg=zero");
				break;
			case "failed":
				response.sendRedirect("Error.jsp?msg=error");
				break;
			}
			
		}
	}

}