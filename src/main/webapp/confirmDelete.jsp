<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Details</title>
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

        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 600px;
            display: flex;
            flex-direction: column;
            
        }


        h1 {
            text-align: center;
            color: #333;
        }

        h3 {
            color: #333;
            margin-bottom: 10px;
        }

        p {
            font-size: 16px;
            color: #555;
            margin: 5px 0;
        }

        .button-container {
            display: flex;
            justify-content: space-around;
            width: 100%;
            max-width: 400px; /* Adjust as needed */
            margin-top: 20px;
        }

        button {
            width: 120px; /* Adjust width as needed */
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
    <div style="display: flex; justify-content: center; align-items: center; height: 100vh;">
        <form action="DeleteConfirm" method="POST">
            <h1>Verify the details and press delete to delete the account....</h1>
            <h3>Account Details</h3>
            <p>Account NO: <%=session.getAttribute("accno") %></p>
            <p>Name: <%=session.getAttribute("name") %></p>
            <p>Address: <%=session.getAttribute("add") %></p>
            <p>Mobile NO: <%=session.getAttribute("phno") %></p>
            <p>Email id: <%=session.getAttribute("email") %></p>
            <p>Account type: <%=session.getAttribute("accty") %></p>
            <p>Initial Balance: <%=session.getAttribute("bal") %></p>
            <p>Date of Birth: <%=session.getAttribute("dob") %></p>
            <p>Id Proof: <%=session.getAttribute("idp") %></p>
            <p>Id Number: <%=session.getAttribute("idn") %></p>
            <input type="hidden" value="<%=session.getAttribute("accno") %>" name="accno" id="accno" />
            <div class="button-container">
                <button type="submit">Delete</button>
                <button type="button" onClick="window.location.href='delete.html'">Back</button>
                <button type="button" onClick="window.location.href='Action.html'">Go back to the action page</button>
            </div>
        </form>
    </div>
</body>

</html>