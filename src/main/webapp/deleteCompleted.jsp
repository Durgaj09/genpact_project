<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Deletion Completion</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 500px;
            text-align: center;
        }

        h1 {
            color: #333;
        }

        p {
            font-size: 18px;
            color: #555;
        }

        .button-group {
            display: flex;
            justify-content: center;
            gap: 10px; /* Space between buttons */
            margin-top: 20px; /* Space above buttons */
        }

        button {
            width: 150px;
            height: 40px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
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
        <h1><u>DELETION COMPLETED:</u></h1>
        <p><%= session.getAttribute("accno") %> has been deleted successfully...</p>
        <div class="button-group">
            <button onClick="window.location.href='confirmDelete.jsp'">Back</button>
            <button onClick="window.location.href='Action.html'">Go back to the action page</button>
        </div>
    </div>
</body>

</html>
