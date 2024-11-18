<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Balance Enquiry</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #E6E6FA; 
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        h2 {
            text-align: center;
            color: #4B0082; 
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #4B0082; 
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.2s;
        }

        input[type="submit"]:hover {
            background-color: #7A1CBE;
        }

        a {
            color: #4B0082; 
            text-decoration: none;
            display: block;
            text-align: center;
            margin-top: 10px;
        }

        a:hover {
            text-decoration: underline; 
        }
    </style>
</head>
<body>
    <form action="balances" method="post">
        <h2>Balance Enquiry</h2>

        <label for="pin">PIN:</label>
        <input type="password" id="pin" name="pin" required><br> <!-- Changed input type to password -->

        <input type="submit" value="Check Balance">
        <%Double balance = (Double) request.getAttribute("bal");  %>
        <%if(balance!=null)
        	{
        	out.print("<h4 style='color:green'>your balance : "+balance+"</h4>");
        	}
        	%>
        
        <a href="home.jsp">Go to Home Page?</a>
    </form>
</body>
</html>
