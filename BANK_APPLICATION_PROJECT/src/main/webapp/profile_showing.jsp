<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="data_transfer_object.User_dto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Details</title>
<style>
    /* Page background and frame */
    body {
        background-color: #f3f4f7;
        margin: 0;
        padding: 20px;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        box-sizing: border-box;
        border: 10px solid #8bc34a; /* Green border for frame effect */
        border-radius: 15px;
    }

    /* Center container for profile and table */
    .profile-container {
        background-color: #fff;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        border-radius: 15px;
        padding: 30px;
        width: 60%;
        text-align: center;
    }

    /* Profile image styling */
    .image-div {
        width: 150px;
        height: 150px;
        border-radius: 50%;
        overflow: hidden;
        border: 5px solid #8bc34a;
        display: flex;
        align-items: center;
        justify-content: center;
        margin: 0 auto 20px;
    }

    .image-div img {
        width: 100%;
        height: 100%;
        object-fit: cover;
    }

    /* Upload button styling */
    .upload-button {
        background-color: #8bc34a;
        color: white;
        font-size: 24px; /* Adjusted size of the plus icon */
        padding: 10px;
        border: none;
        border-radius: 50%;
        cursor: pointer;
        position: relative; /* For positioning the emoji */
        margin-bottom: 5px;
        display: inline-block; /* To center the button */
    }

    .upload-text {
        font-size: 16px; /* Adjust font size */
        color: #333;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .finger-icon {
        margin-left: 5px;
        font-size: 20px; /* Maintain the finger icon size */
    }

    /* Hidden file input for image upload */
    .file-input {
        display: none; /* Hide the actual file input */
    }

    /* Table styling with colorful accents */
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    th, td {
        padding: 15px;
        text-align: center;
        border: 1px solid #ddd;
    }

    th.a {
        background-color: #64b5f6; /* Light blue for headers */
        color: #fff;
        font-weight: bold;
    }

    td.b {
        background-color: #e8f5e9; /* Light green for rows */
    }

    /* Hover effect for table rows */
    tr:hover td {
        background-color: #c8e6c9; /* Lighter green on hover */
    }

    /* Link to Home Page */
    .home-link {
        display: inline-block;
        margin-top: 20px; /* Add some space above the link */
        text-decoration: none; /* Remove underline */
        color: #8bc34a; /* Match the link color with the theme */
        font-size: 18px; /* Adjust font size */
    }

    .home-link:hover {
        text-decoration: underline; /* Underline on hover */
    }
</style>
</head>
<body>

<% User_dto p = (User_dto) request.getAttribute("udto1"); %>

<div class="profile-container">
    <!-- Image Div -->
    <div class="image-div">
        <img alt="Your Image" src="<%= p.getImage() %>">
    </div>

    <!-- Upload Section -->
    <div>
        <form action="updatepr" method="post" enctype="multipart/form-data">
            <label class="upload-button">
                + <!-- Plus icon -->
                <input type="file" class="file-input" name="ima" accept="image/*" onchange="this.form.submit()">
            </label>
            <div class="upload-text">
                <span class="finger-icon">&#9757;</span> <!-- Keep the finger emoji as it is -->
                update your profile
            </div>
        </form>
    </div>

    <!-- Table -->
    <table>
        <tr>
            <th class="a">Name</th>
            <th class="a">Phone</th>
            <th class="a">Email</th>
            <th class="a">Password</th>
            <th class="a">Age</th>
            <th class="a">Gender</th>
            <th class="a">Address</th>
        </tr>
        <tr>
            <td class="b"><%= p.getFirstname() + " " + p.getLastname() %></td>
            <td class="b"><%= p.getPhone() %></td>
            <td class="b"><%= p.getEmail() %></td>
            <td class="b"><%= p.getPwd() %></td>
            <td class="b"><%= p.getAge() %></td>
            <td class="b"><%= p.getGender() %></td>
            <td class="b"><%= p.getAddress() %></td>
        </tr>
    </table>
    
    <!-- Link to Home Page -->
    <a href="home.jsp" class="home-link">Go to Home Page?</a>
</div>

</body>
</html>
