/**
 * 
 */
function toggleMenu() {
    const menu = document.getElementById('sideMenu');
    menu.style.display = menu.style.display === 'flex' ? 'none' : 'flex';
}

// Close the menu when clicking outside
window.onclick = function(event) {
    const menu = document.getElementById('sideMenu');
    const menuIcon = document.querySelector('.menu-icon');
    
    // Check if the click was outside the menu and the menu icon
    if (event.target !== menu && event.target !== menuIcon && !menu.contains(event.target)) {
        menu.style.display = 'none';
    }
};
