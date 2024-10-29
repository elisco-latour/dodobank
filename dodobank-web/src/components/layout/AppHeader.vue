<script setup lang="ts">
console.log('Here is the app Header');
</script>
<template>
    <header id="app-header">
        <!-- <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" /> -->
        <div id="app-brand" class="container-fluid">
            <div class="container">
                <h1 id="app-brand__title">DodoBank</h1>
                <span id="app_brand__description">A bank at your service</span>
            </div>
        </div>
        <nav id="app-navigation" class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <div class="container">
                    <ul class="navbar-nav">
                        <li class="navbar-item">
                            <RouterLink class="nav-link" to="/">Home</RouterLink>
                        </li>
                        <li class="navbar-item">
                            <RouterLink class="nav-link" to="/">Products</RouterLink>
                        </li>
                        <li class="navbar-item">
                            <RouterLink class="nav-link" to="/about">Services</RouterLink>
                        </li>
                        <li class="navbar-item">
                            <RouterLink class="nav-link" to="/about">Learning</RouterLink>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
</template>
<style scoped>
#app-brand {
    width: 100%;
    background: var(--dodobank-color-primary);
    padding: 1.0rem 0;
}

#app-brand__title,
#app_brand__description {
    color: var(--dodobank-color-white);
}
</style>