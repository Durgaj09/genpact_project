<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Credit</title>
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
            width: 90%;
            max-width: 700px; /* Increased max-width */
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        label {
            color: #333;
            margin: 10px 0 5px;
            font-size: 16px;
            width: 100%;
            text-align: left;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            max-width: 500px; /* Increased max-width */
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        .button-container {
            display: flex;
            justify-content: space-around;
            width: 100%;
            max-width: 500px; /* Adjust as needed */
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
            margin: 0 10px; /* Added margin for spacing */
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
        <form action="Transaction1?msg=credit" method="POST">
            <h1>Crediting the amount:</h1>
     
            <input type="hidden" id="name" name="accno" value="${accno}" />
            <label for="desc">Description</label>
            <input id="desc" type="text" name="desc" />
            <label for="amount">Amount</label>
            <input id="amount" type="number" name="amount" />
            <div class="button-container">
                <button type="submit">Credit</button>
                <button type="button" onClick="window.location.href='CustomerAction.jsp'">Back</button>
            </div>
        </form>
    </div>
</body>

</html>
