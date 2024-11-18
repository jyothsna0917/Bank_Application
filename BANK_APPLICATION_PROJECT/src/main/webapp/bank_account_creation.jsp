<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account</title>
    <style>
        /* Remove default scrollbars */
        ::-webkit-scrollbar {
            display: none;
        }
        html {
            scrollbar-width: none; /* For Firefox */
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #E6E6FA;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow: hidden; /* Prevent scrolling */
        }

        form {
            background-color: #fff;
            padding: 15px; /* Increased padding */
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            width: 300px; /* Slightly increased width */
            max-height: 90vh;
            overflow-y: auto; /* Allow internal scroll if needed */
        }

        h1 {
            text-align: center;
            color: #4B0082;
            margin-bottom: 12px; /* Slightly increased margin */
            font-size: 18px; /* Slightly increased font size */
        }

        input[type="text"], input[type="number"], input[type="date"], select {
            width: 100%;
            padding: 7px; /* Increased padding */
            margin: 4px 0; /* Slightly increased gap */
            border: 1px solid #ccc;
            border-radius: 2px;
            box-sizing: border-box;
            font-size: 13px; /* Slightly larger font size */
        }

        input[type="password"] {
            width: 100%;
            padding: 7px; /* Increased padding */
            margin: 4px 0; /* Slightly increased gap */
            border: 1px solid #ccc;
            border-radius: 2px;
            box-sizing: border-box;
            font-size: 13px; /* Slightly larger font size */
        }

        input[type="submit"] {
            width: 100%;
            background-color: #4B0082;
            color: white;
            padding: 10px; /* Slightly increased padding */
            border: none;
            border-radius: 2px;
            cursor: pointer;
            font-size: 13px; /* Increased font size */
        }

        input[type="submit"]:hover {
            background-color: #7A1CBE;
        }

        label {
            font-weight: bold;
            color: #333;
            display: block;
            margin-bottom: 3px; /* Slightly increased gap */
            font-size: 13px; /* Increased font size */
        }

        .form-section {
            margin-bottom: 12px; /* Increased section spacing */
        }

        .link {
            display: block;
            text-align: center;
            margin-top: 10px; /* Increased link margin */
        }

        a {
            color: #4B0082;
            text-decoration: none;
            font-weight: bold;
            font-size: 12px;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <form action="bankregis" method="post">
        <h1>Create Bank Account</h1>

        <div class="form-section">
            <label for="fname">First Name:</label>
            <input type="text" id="fname" name="fname" required>
            <label for="lname">Last Name:</label>
            <input type="text" id="lname" name="lname" required>
        </div>

        <div class="form-section">
            <label for="permanentAddress">Permanent Address:</label>
            <input type="text" id="permanentAddress" name="address">
        </div>

        <div class="form-section">
            <label for="aadhar">Aadhar Card Number:</label>
            <input type="text" id="aadhar" name="adhar" required>
        </div>

        <div class="form-section">
            <label for="pan">PAN Card Number:</label>
            <input type="text" id="pan" name="pan" required>
        </div>

        <div class="form-section">
            <label for="setPin">Set PIN:</label>
            <input type="password" id="setPin" name="pin" required>
        </div>

        <div class="form-section">
            <label for="type">Account Type:</label>
            <select id="type" name="type" required>
                <option value="" disabled selected>Select Account Type</option>
                <option value="Savings">Savings</option>
                <option value="Current">Current</option>
            </select>
        </div>

        <div class="form-section">
            <label for="initialDeposit">Initial Deposit Amount:</label>
            <input type="text" id="initialDeposit" name="amount" min="0" required>
        </div>

        <input type="submit" value="Create Account">
        <div class="link">
            <a href="home.jsp">Go to Home Page?</a>
        </div>
    </form>
</body>
</html>
