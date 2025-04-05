function toggleAuth() {
    const loginForm = document.getElementById('loginForm');
    const registerForm = document.getElementById('registerForm');
    const authTitle = document.getElementById('authTitle');
    const toggleAuthText = document.getElementById('toggleAuth');

    if (loginForm.style.display === 'none') {
        loginForm.style.display = 'block';
        registerForm.style.display = 'none';
        authTitle.textContent = 'Login';
        toggleAuthText.innerHTML = "Don't have an account? <a href='#' onclick='toggleAuth()'>Register</a>";
    } else {
        loginForm.style.display = 'none';
        registerForm.style.display = 'block';
        authTitle.textContent = 'Register';
        toggleAuthText.innerHTML = "Already have an account? <a href='#' onclick='toggleAuth()'>Login</a>";
    }
}