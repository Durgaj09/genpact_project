<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
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
            text-align: left;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
            text-align: center;
        }

        p {
            margin: 10px 0;
            color: #555;
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
            margin-top: 20px;
        }

        button:hover {
            background-color: #45a049;
        }

        button:focus {
            outline: none;
            box-shadow: 0 0 0 2px #4CAF50;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Profile</h1>
        <p>Account No: ${accno}</p>
        <p>Name: ${name}</p>
        <p>Date of Birth: ${dob}</p>
        <p>Address: ${add}</p>
        <p>Mobile No: ${phno}</p>
        <p>Email Id: ${email}</p>
        <p>Account Type: ${accty}</p>
        <p>ID Proof: ${idp}</p>
        <p>ID Number: ${idn}</p>
        <form action="login_Client.html">
            <button type="submit">Logout</button>
        </form>
    </div>
</body>
</html>
