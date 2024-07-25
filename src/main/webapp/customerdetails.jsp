<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.bank.DAO.customerDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bank.Model.Customer" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h2, h3 {
            color: #333;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
            margin: 10px 0;
        }

        button:hover {
            background-color: #45a049;
        }

        button:focus {
            outline: none;
            box-shadow: 0 0 0 2px #4CAF50;
        }

        input[type="search"] {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 200px;
            margin-right: 10px;
        }

        table {
            width: 100%;
            max-width: 1000px;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        .button-container {
            display: flex;
            justify-content: center;
            width: 100%;
        }
    </style>
</head>

<body>
    <h2>Customer Details</h2>


    <div>
        <input type="search" name="search" id="search" placeholder="Search customer..." />
        <button>Search</button>
    </div>

    <div>
        <table>
            <thead>
                <tr>
                    <th>S.No</th>
                    <th>Full Name</th>
                    <th>Address</th>
                    <th>Mobile</th>
                    <th>Email</th>
                    <th>DOB</th>
                    <th>Account Type</th>
                    <th>Account Number</th>
                    <th>ID Proof</th>
                    <th>ID Number</th>
                </tr>
            </thead>
            <tbody>
                <%
                    customerDAO dao = new customerDAO();
                    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
                    if (customers == null) {
                        customers = dao.getAllCustomers();
                    }

                    int i = 1;
                    for (Customer customer : customers) {
                %>
                <tr>
                    <td><%= i++ %></td>
                    <td><%= customer.getName() %></td>
                    <td><%= customer.getAddress() %></td>
                    <td><%= customer.getMobile_no() %></td>
                    <td><%= customer.getEmail_id() %></td>
                    <td><%= customer.getDate_of_Birth() %></td>
                    <td><%= customer.getAccount_type() %></td>
                    <td><%= customer.getAccount_Number() %></td>
                    <td><%= customer.getId_proof() %></td>
                    <td><%= customer.getId_number() %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>

</html>
