<template>
    <footer id="app-footer" class="container-fluid">
        <div class="container">
            <nav id="app-footer-navigation" class="navbar  navbar-expand-lg">
                <ul>
                    <li>
                        <a href="#">Terms & conditions</a>
                    </li>
                    <li>
                        <a href="#">Personal Data</a>
                    </li>
                </ul>
            </nav>
        </div>
    </footer>
</template>
<style scoped>
ul {
    display: flex;
    padding-left: 0;
    margin-left: 0;
    list-style: none;
    width: 100%;
    gap: var(--dodobank-gap-16);
}

a {
    color: var(--dodobank-color-primary);
    text-decoration: none;
}
</style>