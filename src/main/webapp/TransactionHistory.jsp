<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.bank.DAO.customerDAO" %>
    <%@page import="java.util.List" %>
    <%@page import="com.bank.Model.Transaction" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Statement</title>
<style>
body {
    font-family: 'Roboto', sans-serif;
    background-color: #f4f6f9;
    margin: 0;
    padding: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    color: #343a40;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    background-color: white;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
}

thead {
    background-color: #007bff;
    color: white;
}

th, td {
    padding: 10px;
    text-align: left;
}

tbody tr:nth-child(even) {
    background-color: #f2f2f2;
}

tbody tr:hover {
    background-color: #e9ecef;
}

</style>
</head>
<body>
	<div>
	<button onclick="window.print()">print</button>
		<table>
			<thead>
				<tr>
					<th>S.No</th>
					<th>Date</th>
					<th>Description</th>
					<th>Credit</th>
					<th>Debit</th>
					<th>Balance</th>
				</tr>
			</thead>
			<tbody>
				<%
					String accno=request.getParameter("accno");
					System.out.println(accno);
					customerDAO dao=new customerDAO();
					List<Transaction> customers=null;
					if(customers==null){
						customers=dao.getTransactions(accno);
					}
					int i=1;
					for(Transaction customer:customers){
						
				%>
				
					<tr>
						<td><%= i++ %></td>
						<td><%= customer.getDate() %></td>
						<td><%= customer.getDesc() %></td>
						<td><%= customer.getCredit() %></td>
						<td><%= customer.getDebit() %></td>
						<td><%= customer.getBalance() %></td>
					</tr>
				
				<%
					}
				%>
				<h2><%= accno %></h2>
			</tbody>
		</table>
	</div>
</body>
</html>