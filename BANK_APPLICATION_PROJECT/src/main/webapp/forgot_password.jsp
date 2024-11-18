<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Arial', sans-serif;
        }

        body {
            background: linear-gradient(120deg, #74ebd5, #acb6e5);
            background-size: 400% 400%;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
            animation: gradientAnimation 15s ease infinite;
        }

        @keyframes gradientAnimation {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        .form-container {
            background: #fff;
            padding: 30px;
            border-radius: 12px;
            width: 100%;
            max-width: 400px;
            box-shadow: 0 8px 24px rgba(0, 0, 0, 0.2);
            animation: slideUp 1s ease-out;
        }

        @keyframes slideUp {
            from {
                transform: translateY(40px);
                opacity: 0;
            }
            to {
                transform: translateY(0);
                opacity: 1;
            }
        }

        .form-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #444;
            font-size: 24px;
            font-weight: bold;
        }

        .form-container input {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 8px;
            background: #f9f9f9;
            color: #333;
            font-size: 16px;
            transition: all 0.3s ease;
        }

        .form-container input:focus {
            outline: none;
            background-color: #f0f8ff;
            border-color: #74ebd5;
            box-shadow: 0 0 10px rgba(116, 235, 213, 0.4);
        }

        .form-container input[type="submit"] {
            background: #74ebd5;
            border: none;
            color: white;
            cursor: pointer;
            font-size: 18px;
            padding: 12px;
            margin-top: 10px;
            transition: transform 0.3s ease, background-color 0.3s ease;
            border-radius: 8px;
        }

        .form-container input[type="submit"]:hover {
            background: #66d3c8;
            transform: scale(1.05);
        }

        .form-container label {
            font-size: 14px;
            color: #555;
        }

        .error-message {
            color: red;
            font-size: 13px;
            margin-top: -5px;
            margin-bottom: 10px;
            opacity: 0;
            height: 15px;
            transition: opacity 0.5s ease;
        }

        .error-message.active {
            opacity: 1;
        }

        @media (max-width: 768px) {
            .form-container {
                padding: 20px;
            }
            .form-container input {
                font-size: 14px;
            }
            .form-container h2 {
                font-size: 22px;
            }
        }

        @media (max-width: 480px) {
            .form-container {
                padding: 15px;
            }
            .form-container input {
                font-size: 12px;
            }
            .form-container h2 {
                font-size: 18px;
            }
            .login-link {
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>Reset Your Password</h2>
        <form id="forgotPasswordForm" action="processForgotPassword" method="POST" onsubmit="return validateForm()">
            <label for="email">Email</label>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>
            <!-- Display error message for email -->
            <span style="color:red;">
                <%String s=(String)request.getAttribute("s");%>
                <%if(s!=null)
                	{
                	out.print(s);
                	}
                	%>
            </span><br>

            <label for="new_password">New Password</label>
            <input type="password" id="new_password" name="pwd" placeholder="Enter your new password" required>

            <label for="confirm_password">Confirm Password</label>
            <input type="password" id="confirm_password" name="confirm_password" placeholder="Confirm your new password" required>
            <span class="error-message" id="error-message"> </span>
            <input type="submit" value="Reset Password">
        </form>
        <div class="login-link">
            <p>Are you remembered your password? <a href="login_page.jsp">Login here</a></p>
        </div>
    </div>

    <script>
        function validateForm() {
            var newPassword = document.getElementById('new_password').value;
            var confirmPassword = document.getElementById('confirm_password').value;
            var errorMessage = document.getElementById('error-message');
            var passwordPattern = /^(?=.*[A-Z])(?=.*\d)(?=.*[$@])[A-Za-z\d$@]{8,}$/;

            // Check if passwords match
            if (newPassword !== confirmPassword) {
                errorMessage.textContent = "Passwords do not match!";
                errorMessage.classList.add('active');
                return false;
            }

            // Check password complexity
            if (!passwordPattern.test(newPassword)) {
                errorMessage.textContent = "Password must be at least 8 characters long, contain at least one uppercase letter, one number, and special characters ($ or @) only.";
                errorMessage.classList.add('active');
                return false;
            }

            // Clear error message
            errorMessage.textContent = "";
            errorMessage.classList.remove('active');
            return true;
        }
    </script>

</body>
</html>
