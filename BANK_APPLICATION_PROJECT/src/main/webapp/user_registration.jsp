<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Page</title>
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

        .container {
            background-color: #fff; 
            padding: 10px; /* Decreased padding */
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            width: 350px;
            max-width: 90%;
            margin: 0;
        }

        h2 {
            text-align: center;
            color: #4B0082; 
            margin-bottom: 8px; /* Decreased margin */
            font-size: 18px;
        }

        input[type="text"], input[type="email"], input[type="password"], input[type="number"], input[type="file"], select {
            width: 100%;
            padding: 5px; /* Decreased padding for input fields */
            margin: 4px 0; /* Decreased margin */
            border: 1px solid #8A2BE2; 
            border-radius: 2px;
            box-sizing: border-box;
            font-size: 12px; 
            color: #4B0082; 
        }

        input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus, input[type="number"]:focus, select:focus {
            border: 1px solid #4B0082; 
            outline: none; 
        }

        input[type="submit"] {
            width: 100%;
            background-color: #8A2BE2; 
            color: white;
            padding: 8px; /* Kept padding for submit button */
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 15px;
            margin-top: 8px; /* Decreased margin */
        }

        input[type="submit"]:hover {
            background-color: #7A1CBE; 
        }

        label {
            display: block;
            margin-bottom: 2px; /* Decreased margin */
            font-weight: bold;
            color: #4B0082; 
        }

        .login-link {
            text-align: center;
            margin-top: 10px;
        }

        .login-link a {
            color: #4CAF50; 
            text-decoration: none;
            font-size: 13px;
        }

        .login-link a:hover {
            text-decoration: underline;
        }

        .error {
            color: red;
            font-size: 12px;
            display: none; /* Initially hidden */
        }
    </style>
    <script>
        function validatePassword() {
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confirm_password").value;
            var errorMsg = document.getElementById("error_message");

            if (password !== confirmPassword) {
                errorMsg.style.display = "block";
                errorMsg.textContent = "Passwords do not match!";
                return false;
            } else {
                errorMsg.style.display = "none";
                return true;
            }
        }
    </script>
</head>
<body>
    <div class="container">
        <form action="RegisterServle" method="post" enctype="multipart/form-data" onsubmit="return validatePassword();">
            <h2>Register</h2>
            <label for="first_name">First Name:</label>
            <input type="text" id="first_name" name="firstname" required>

            <label for="last_name">Last Name:</label>
            <input type="text" id="last_name" name="lastname" required>

            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="pwd" required>

            <label for="confirm_password">Confirm Password:</label>
            <input type="password" id="confirm_password" name="confirm_password" required>
            <span class="error" id="error_message">Passwords do not match!</span>

            <label for="phone_number">Phone Number:</label>
            <input type="text" id="phone_number" name="phone" required>

            <label for="age">Age:</label>
            <input type="number" id="age" name="ag" required>

            <label for="gender">Gender:</label>
            <select id="gender" name="gender">
                <option value="Male">Male</option>
                <option value="Female">Female</option>
                <option value="Other">Other</option>
            </select>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>

            <label for="image">Upload Image:</label>
            <input type="file" id="image" name="ima" accept="image/*">

            <input type="submit" value="Register">
        </form>
        <%String s=(String)request.getAttribute("s"); %>
        <%if(s!=null)
        	{
        	out.print("<h4 style='color:red'>"+s+"</h4>");
        	}
        	%>
        <div class="login-link">
            <p>Already have an account? <a href="login_page.jsp">Login here</a></p>
        </div>
    </div>
</body>
</html>
