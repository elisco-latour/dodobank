<template>
    <div id="home-auth__section">
        <h2 class="fw-light">Online Banking</h2>
        <div id="auth-actions">
            <a id="login-button" rel="stylesheet" href="#" class="btn btn-success">Log In</a>
            <a id="signup-button" rel="stylesheet" href="#" class="btn btn-outline-secondary">
                Sign Up
                <i class="bi bi-arrow-right-short"></i>
            </a>
        </div>
        <ul id="auth-actions-nav">
            <li><a href="">Learn more about Personal Online Banking <i class="bi bi-arrow-right-short"></i></a></li>
            <li><a href="">Learn more about Small Business OOnline Banking <i class="bi bi-arrow-right-short"></i></a>
            </li>
        </ul>
    </div>
</template>
<style>
#home-auth__section {
    height: 100%;
    padding: 2rem;
    border-left: 1px solid var(--dodobank-color-primary);
}

#auth-actions {
    display: flex;
    gap: var(--dodobank-gap-16);
}

#auth-actions-nav {
    list-style-type: none;
    padding-left: 0;
    margin-left: 0;
    margin-top: 2rem;
}

#auth-actions-nav li {
    margin-bottom: 0.5rem;
}

#auth-actions-nav li a {
    color: var(--dodobank-color-primary);
    text-decoration: none;
}

#auth-actions-nav li a:hover {
    background-color: none;
}

#login-button {
    flex: 2;
}
</style>