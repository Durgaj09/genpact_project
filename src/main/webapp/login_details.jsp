<html>
<head>
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
            flex-direction: column;
        }

        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            box-sizing: border-box;
             	
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        p {
            font-size: 16px;
            color: #333;
            margin: 10px 0;
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
            margin-top: 10px; /* Add spacing between buttons */
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
        <h1>Customer Details Added Successfully</h1>
        <p>Name: <%=session.getAttribute("name")%></p>
        <p>Account Number: <%=session.getAttribute("accno")%></p>
        <p>Pin: <%=session.getAttribute("pin")%></p>
        
        <button type="button" onClick="window.location.href='Action.html'">Go back to the action page</button>
        <button type="button" onClick="window.location.href='insert.html'">Back</button>
    </div>
</body>
</html>
