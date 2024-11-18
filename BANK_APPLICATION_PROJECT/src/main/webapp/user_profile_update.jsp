<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="data_transfer_object.User_dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Profile</title>
<style>
    /* Your CSS styling as-is */
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
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            width: 350px;
            text-align: center;
        }

        h1 {
            color: #4B0082; 
            margin-bottom: 20px;
        }

        input[type="text"], input[type="number"], select {
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

        label {
            font-weight: bold;
            color: #333;
            margin-bottom: 5px;
            display: block;
        }

        .home-link {
            margin-top: 15px;
        }

        .home-link a {
            color: #4B0082; 
            text-decoration: none;
            font-size: 14px;
        }

        .home-link a:hover {
            text-decoration: underline;
        }
</style>
</head>
<body>
<% 
    User_dto p = (User_dto) request.getAttribute("udto"); 
%>
<form action="UpdateServlet" method="post">
    <h1>Update Profile</h1>

    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" value="<%=p != null ? p.getFirstname() : "" %>"><br>

    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" value="<%=p != null ? p.getLastname() : "" %>"><br>

    <label for="mobileNumber">Mobile Number:</label>
    <input type="text" id="phno" name="phno" value="<%=p != null ? p.getPhone() : "" %>"><br>

    <label for="age">Age:</label>
    <input type="number" id="age" name="age" value="<%=p != null ? p.getAge() : "" %>"><br>

    <label for="gender">Gender:</label>
    <select id="gender" name="gender">
        <option value="Male" <%= p != null && "Male".equals(p.getGender()) ? "selected" : "" %>>Male</option>
        <option value="Female" <%= p != null && "Female".equals(p.getGender()) ? "selected" : "" %>>Female</option>
        <option value="Other" <%= p != null && "Other".equals(p.getGender()) ? "selected" : "" %>>Other</option>
    </select><br><br>

    <input type="submit" value="Update Profile">
    <div class="home-link">
        <a href="home.jsp">Go to Home Page?</a>
    </div>
</form>

<% 
    String s = (String) request.getAttribute("s1"); 
    if(s != null) {
%>
    <h3 style="color:green;margin-left:5%;margin-top:15%"><%= s %></h3>
<%
    }
%>
</body>
</html>
