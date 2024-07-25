<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Customer Action</title>
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
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 80%;
            max-width: 600px; /* Reduced max-width */
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            width: 100%;
            max-width: 400px; /* Reduced max-width */
            margin-bottom: 15px; /* Reduced margin */
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        button {
            width: 120px;
            height: 40px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin: 5px 0; /* Reduced margin for spacing */
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
        <h1>Customer Actions</h1>

        <!-- Profile Form -->
        <form action="Profile" method="POST">
            <input type="hidden" id="name" name="name" value="${name}" />
            <input type="hidden" id="accno" name="accno" value="${accno}" />
            <button type="submit">Profile</button>
        </form>

        <!-- Credit Form -->
        <form action="Credit" method="POST">
            <input type="hidden" id="name" name="name" value="${name}" />
            <input type="hidden" id="accno" name="accno" value="${accno}" />
            <button type="submit">Credit</button>
        </form>

        <!-- Debit Form -->
        <form action="Debit" method="POST">
            <input type="hidden" id="name" name="name" value="${name}" />
            <input type="hidden" id="accno" name="accno" value="${accno}" />
            <button type="submit">Debit</button>
        </form>

        <!-- Transaction History Form -->
        <form action="TransactionHistory" method="POST">
            <input type="hidden" id="name" name="name" value="${name}" />
            <input type="hidden" id="accno" name="accno" value="${accno}" />
            <button type="submit">Transaction History</button>
        </form>

        <!-- Reset Password Form -->
        <form action="Reset" method="POST">
            <input type="hidden" id="name" name="name" value="${name}" />
            <input type="hidden" id="accno" name="accno" value="${accno}" />
            <button type="submit">Reset Password?</button>
        </form>

        <!-- Logout Button -->
        <form action="login_Client.html">
            <button type="submit">Logout</button>
        </form>
    </div>
</body>

</html>
