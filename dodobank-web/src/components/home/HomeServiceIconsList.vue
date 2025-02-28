<script setup lang="ts">
export interface IDodoService {
    id: string;
    name: string;
    imageUrl: string,
    description: string;
    icon: string;
    expanded: boolean;
}
const services: Array<IDodoService> = [
    {
        id: "service_savings",
        name: "Savings",
        imageUrl: "savings.jpg",
        description: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
        icon: "bi-piggy-bank",
        expanded: true,
    },
    {
        id: "service_credit_card",
        name: "Credit Cards",
        imageUrl: "credit-card.jpg",
        description: "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        icon: "bi-credit-card",
        expanded: false,
    },
    {
        id: "service_wallet",
        name: "Wallet",
        imageUrl: "wallet.jpg",
        description: "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
        icon: "bi-wallet2",
        expanded: false,
    },
    {
        id: "service_creypto_currency",
        name: "Crypto Currency Exchange",
        imageUrl: "cryptocurrency.jpg",
        description: "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",
        icon: "bi-currency-bitcoin",
        expanded: false
    },
    {
        id: "service_loans",
        name: "Loans",
        imageUrl: "loans.jpg",
        description: "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy.",
        icon: "bi-cash-stack",
        expanded: false,
    }
];
</script>
<template>
    <ul id="service-icons__list">
        <li class="service-icon" v-for="service in services" :key="service.icon">
            <a data-bs-toggle="collapse" :href="`#${service.id}`" role="button" :aria-expanded="service.expanded"
                :aria-controls="service.id">
                <i class="bi" :class="service.icon"></i>
            </a>
        </li>
    </ul>
    <div v-for="service in services" :key="service.id" class="collapse" :id="service.id">
        {{ service.description }}
    </div>

</template>
<style scoped>
#service-icons__list {
    display: flex;
    list-style: none;
    gap: var(--dodobank-gap-24);
    justify-content: center;
}

.service-icon {
    height: 6.0rem;
    width: 6.0rem;
    border: 1px solid var(--dodobank-color-primary);
    border-radius: 100%;

    display: flex;
    justify-content: center;
    align-items: center;
    transition: all .7s cubic-bezier(0.075, 0.82, 0.165, 1);
}

.service-icon a {
    text-decoration: none;
    width: 100%;
    height: 100%;

    border: 1px solid var(--dodobank-color-primary);
    border-radius: 100%;

    display: flex;
    justify-content: center;
    align-items: center;
    transition: all .7s cubic-bezier(0.075, 0.82, 0.165, 1);
}

.service-icon:hover {
    background-color: var(--dodobank-color-primary);
}

.service-icon i.bi::before {
    display: block;
    font-size: 3.0rem;
    color: var(--dodobank-color-primary);
    transition: all .7s cubic-bezier(0.075, 0.82, 0.165, 1);
}

.service-icon:hover i.bi::before {
    color: var(--dodobank-color-white);
}
</style>