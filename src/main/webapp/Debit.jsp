<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Debit</title>
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
            max-width: 500px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        label {
            margin: 10px 0 5px;
            font-size: 16px;
            color: #333;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 15px;
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
            margin: 5px 0;
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
        <h1>Debiting the amount:</h1>
        <form action="Transaction1?msg=debit" method="POST">
            <input type="hidden" id="name" name="accno" value="${accno}" />
            <label for="desc">Description</label>
            <input id="desc" type="text" name="desc" />
            <label for="amount">Amount</label>
            <input id="amount" type="number" name="amount" />
            <button type="submit">Debit</button>
             <button type="button" onClick="window.location.href='CustomerAction.jsp'">Back</button>
        </form>
    </div>
</body>

</html>
