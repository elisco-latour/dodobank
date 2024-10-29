<template>
    <ul>
        <li><i class="bi bi-piggy-bank"></i></li>
        <li><i class="bi bi-credit-card"></i></li>
        <li><i class="bi bi-wallet2"></i></li>
        <li><i class="bi bi-currency-bitcoin"></i></li>
        <li><i class="bi bi-cash-stack"></i></li>
    </ul>
</template>
<style scoped>
ul {
    display: flex;
    list-style: none;
    gap: var(--dodobank-gap-24);
    justify-content: center;
}

ul li {
    height: 6.0rem;
    width: 6.0rem;
    border: 1px solid var(--dodobank-color-primary);
    border-radius: 100%;

    display: flex;
    justify-content: center;
    align-items: center;
    transition: all .7s cubic-bezier(0.075, 0.82, 0.165, 1);
}

ul li:hover {
    background-color: var(--dodobank-color-primary);
}

ul li i.bi::before {
    display: block;
    font-size: 3.0rem;
    color: var(--dodobank-color-primary);
    transition: all .7s cubic-bezier(0.075, 0.82, 0.165, 1);
}

ul li:hover i.bi::before {
    color: var(--dodobank-color-white);
}
</style>