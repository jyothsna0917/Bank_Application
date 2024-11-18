<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Login</title>
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
            overflow: hidden;
        }

        .container, .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            width: 350px;
            max-width: 90%;
        }

        .title {
            text-align: center;
            color: #4B0082;
            margin-bottom: 8px;
            font-size: 18px;
        }

        .input, input[type="email"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #8A2BE2;
            border-radius: 20px; /* Rounded corners for input fields */
            font-size: 14px;
            color: #4B0082;
            box-sizing: border-box;
            outline: none;
            transition: border-color 0.3s;
        }

        .input:focus, input[type="email"]:focus, input[type="password"]:focus {
            border-color: #4B0082;
        }

        .form-btn {
            width: 100%;
            background-color: #8A2BE2;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 20px;
            cursor: pointer;
            font-size: 15px;
            margin-top: 8px;
            transition: background-color 0.3s;
        }

        .form-btn:hover {
            background-color: #7A1CBE;
        }

        .page-link, .sign-up-label {
            text-align: center;
            margin-top: 10px;
        }

        .page-link a, .sign-up-link {
            color: #4CAF50;
            text-decoration: none;
            font-size: 13px;
        }

        .page-link a:hover, .sign-up-link:hover {
            text-decoration: underline;
        }

        .error {
            color: red;
            font-size: 12px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <p class="title">Account Login</p>
        <form class="form" action="login" method="post">
            <input type="email" class="input" placeholder="Email" name="email" required>
            <input type="password" class="input" placeholder="Password" name="pwd" required>

            <button type="submit" class="form-btn">Log in</button>

            <p class="page-link">
                <a href="forgot_password.jsp" class="page-link-label">Forgot Password?</a>
            </p>

            <% String s = (String) request.getAttribute("result"); %>
            <% if (s != null) { %>
                <h4 class="error"><%= s %></h4>
            <% } %>
        </form>

        <p class="sign-up-label">
            Don't have an account? <a href="user_registration.jsp" class="sign-up-link">Register Now</a>
        </p>
    </div>
</body>
</html>
