<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="home.css">
</head>
<body>
<div class="navbar">
    <div class="menu-wrapper">
        <div class="menu-icon" onclick="toggleMenu()">&#9776;</div>
        <div class="side-menu" id="sideMenu">
            <a href="profi" class="menu-item profile">Profile</a>
            <a href="user_profile_update.jsp" class="menu-item update">Update</a>
            <a href="#" class="menu-item delete" onclick="confirmDelete(event)">Delete</a>
            <a href="logo" class="menu-item logout">Log Out</a>
        </div>
    </div>
    <div class="actions">
        <a href="show_balances.jsp" class="action-button">Show Balance</a>
        <a href="transfer_amount.jsp" class="action-button">Transfer</a>
        <a href="bank_account_creation.jsp" class="action-button">Create Account</a>
    </div>
</div>
<script src="home.js"></script>
<script>
function confirmDelete(event) {
    // Prevent the default action of the link
    event.preventDefault();

    // Display confirmation dialog
    const userConfirmed = confirm("Are you sure you want to delete your account?");
    
    // If user clicked "Yes", proceed to delete action
    if (userConfirmed) {
        // Redirect to the delete action
        window.location.href = "dele";
    }
}
</script>
</body>
</html>
