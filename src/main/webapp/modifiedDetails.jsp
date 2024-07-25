<html>
<head>
    <title>Details Modified</title>
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
            max-width: 500px;
            box-sizing: border-box;
            text-align: center;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        h3 {
            color: #666;
            margin-bottom: 15px;
        }

        p {
            font-size: 16px;
            color: #333;
            margin: 10px 0;
            text-align: left; /* Align text to the left */
        }
    button {
        width: 100%; /* Full width */
        padding: 10px; /* Padding inside the button */
        font-size: 16px; /* Font size */
        background-color: #4CAF50; /* Button background color */
        color: white; /* Text color */
        border: none; /* Remove border */
        border-radius: 5px; /* Rounded corners */
        cursor: pointer; /* Pointer cursor on hover */
        transition: background-color 0.3s ease; /* Smooth background color transition */
        margin-top: 10px; /* Spacing above the button */
    }

    button:hover {
        background-color: #45a049; /* Darker green on hover */
    }

    button:focus {
        outline: none; /* Remove outline */
        box-shadow: 0 0 0 2px #4CAF50; /* Focus shadow */
    }
        
    </style>
</head>
<body>
    <div class="container">
        <h1>The Details Have Been Modified</h1>
        <h3>Modified Details</h3>
        <p>Account No: ${accno}</p>
        <p>Name: ${name}</p>
        <p>Address: ${add}</p>
        <p>Mobile No: ${phno}</p>
        <p>Email ID: ${email}</p>
        <p>Account Type: ${accty}</p>
        <p>Initial Balance: ${bal}</p>
        <p>Date of Birth: ${dob}</p>
        <p>ID Proof: ${idp}</p>
        <p>ID Number: ${idn}</p>
        <button type="submit" onClick="window.location.href='Action.html'">Ok </button>
    </div>
</body>
</html>
