<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            padding: 20px;
            box-sizing: border-box;
        }

        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
            box-sizing: border-box;
            text-align: left;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }

        label {
            font-size: 16px;
            color: #333;
        }

        input[type="text"],
        input[type="tel"],
        input[type="email"],
        input[type="number"],
        select {
            width: calc(100% - 20px);
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-top: 5px;
        }

        button {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 10px;
        }

        button:hover {
            background-color: #45a049;
        }

        button:focus {
            outline: none;
            box-shadow: 0 0 0 2px #4CAF50;
        }

        table {
            width: 100%;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>CUSTOMER DETAILS:</h1>
        <p>Account Number: ${accno}</p>
        <form action="AdminModifyDetails" method="POST">
            <table>
                <tr>
                    <td>
                        <label for="name">Enter Full Name:</label>
                    </td>
                    <td>
                        <input type="text" id="name" name="name" value="${name}" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="address">Enter Address:</label>
                    </td>
                    <td>
                        <input type="text" id="address" name="add" value="${add}" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="phno">Enter Mobile Number:</label>
                    </td>
                    <td>
                        <input type="tel" id="phno" name="phno" value="${phno}" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="email">Enter Email ID:</label>
                    </td>
                    <td>
                        <input type="email" id="email" name="email" value="${email}" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="DOB">Enter Date of Birth:</label>
                    </td>
                    <td>
                        <input type="text" id="date" name="dob" placeholder="dd/mm/yyyy" value="${dob}" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="idproof">Enter ID Proof:</label>
                    </td>
                    <td>
                        <select name="idp" id="idproof" required>
                            <option value="none">Select an option</option>
                            <option value="aadhar" ${idp eq 'aadhar' ? 'selected' : ''}>Aadhar Card</option>
                            <option value="pan" ${idp eq 'pan' ? 'selected' : ''}>PAN Card</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="idnumber">ID Number:</label>
                    </td>
                    <td>
                        <input type="number" id="idnumber" name="idn" value="${idn}" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="account">Enter Account Type:</label>
                    </td>
                    <td>
                        <select name="accty" id="account" required>
                            <option value="None">Select an option</option>
                            <option value="saving" ${accty eq 'saving' ? 'selected':'' }>Saving Account</option>
                            <option value="current" ${accty eq 'current' ? 'selected':'' }>Current Account</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="balance">Enter Initial Balance:</label>
                    </td>
                    <td>
                        <input type="text" id="balance" name="bal" value="${bal}" placeholder="Minimum 1000" required>
                    </td>
                </tr>
                <input type="hidden" name="accno" value="${accno}" id="accno"/>
                <tr>
                    <td colspan="2">
                        <button type="submit">Modify</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>