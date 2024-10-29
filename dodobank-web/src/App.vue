<script setup lang="ts">
import AppHeader from './components/layout/AppHeader.vue';
import 'bootstrap-icons/font/bootstrap-icons.min.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';
import AppFooter from './components/layout/AppFooter.vue';
import AppContent from './components/layout/AppContent.vue';
</script>

<template>
  <AppHeader />
  <AppContent />
  <AppFooter />
</template>

<style scoped>
#app-main {
  width: 100%;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}


/* nav a.router-link-exact-active {
  color: var(--color-text);
}

nav a.router-link-exact-active:hover {
  background-color: transparent;
}

nav a {
  display: inline-block;
  padding: 0 1rem;
  border-left: 1px solid var(--color-border);
}

nav a:first-of-type {
  border: 0;
} */

@media (min-width: 1024px) {
  /* header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  } */

  .logo {
    margin: 0 2rem 0 0;
  }
}
</style>
