<script setup lang="ts">
import { computed, reactive, ref, type Reactive } from 'vue';

export interface IDodoService {
  id: string;
  name: string;
  imageUrl: string,
  description: string;
  icon: string;
  selected: boolean;
}

export interface ElementAnimatedStyles{
  translateX: number;
}

const services: Reactive<Array<IDodoService>> = reactive([
  {
    id: "service_savings",
    name: "Savings",
    imageUrl: "savings.jpg",
    description: "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
    icon: "bi-piggy-bank",
    selected: true,
  },
  {
    id: "service_credit_card",
    name: "Credit Cards",
    imageUrl: "credit-card.jpg",
    description: "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
    icon: "bi-credit-card",
    selected: false,
  },
  {
    id: "service_wallet",
    name: "Wallet",
    imageUrl: "wallet.jpg",
    description: "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
    icon: "bi-wallet2",
    selected: false,
  },
  {
    id: "service_creypto_currency",
    name: "Crypto Currency Exchange",
    imageUrl: "cryptocurrency.jpg",
    description: "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.",
    icon: "bi-currency-bitcoin",
    selected: false
  },
  {
    id: "service_loans",
    name: "Loans",
    imageUrl: "loans.jpg",
    description: "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy.",
    icon: "bi-cash-stack",
    selected: false,
  }
]);

const servicesListWrapperElementId = "service-card__list";

const translateX = ref(0);

const servicesListElementStyle = computed(() => ({
  transform: `translateX(${translateX.value}px)`,
  transition: 'all ease-in-out 0.3s',
}));

const translateElement = () => {
  translateX.value += 325;
};

const selectService = (service: IDodoService): void => {
  let currentSelectedService: IDodoService;

  if (service.selected) {
    currentSelectedService = service;
    return;
  }

  currentSelectedService = getCurrentSelectedService()
  unSelectCurrentService(currentSelectedService);
  service.selected = true;
  const servicesListElement = getServicesListWrapperElement(servicesListWrapperElementId)!;
  const selectedServiceElement = getSelectedServiceElement(service, servicesListElement);
  const boundingRect: DOMRect | undefined = selectedServiceElement?.getBoundingClientRect();
  const hiddenPartWidth = boundingRect!.right - boundingRect!.width - (servicesListElement?.clientWidth ?? 0 ) ;
  console.log("hiddenPartWidth", hiddenPartWidth);
  console.log(currentSelectedService.id,"Bounding Rect",selectedServiceElement?.getBoundingClientRect());
  // translateElement();

}

const getServicesListWrapperElement = (elementID: string): HTMLElement | null => {
  return document.querySelector(`#${elementID}`);
};

const getSelectedServiceElement = (service: IDodoService, servicesListElement: HTMLElement): Element | null | undefined => {
  return servicesListElement.querySelector(`#${service.id}`);
};

const unSelectCurrentService = (service: IDodoService): void => {
  service.selected = false;
}

const getCurrentSelectedService = (): IDodoService => {
  return services.find((_service: IDodoService) => _service.selected === true) ?? services[0];
}


</script>
<template>
  <div class="container">
    <div id="service-card__list--wrapper">
      <ul id="service-card__list" :style="servicesListElementStyle">
        <li v-for="service in services" :key="service.id" class="service-card" :class="[`${service.id}__list--item`]"
          :id="service.id">
          <div class="service-card__inner" style="--clr:#fff;">
            <div class="service-card__inner-box">
              <div class="service-card__image">
                <img :src="`/src/assets/images/services/${service.imageUrl}`" :alt="service.name">
              </div>
              <div class="service-card-icon">
                <a href="#" class="iconBox"><i class="bi" :class="service.icon"></i></a>
              </div>
            </div>
          </div>
          <div class="content">
            <h3>{{ service.name }}</h3>
            <p>{{ service.description }}</p>
          </div>
        </li>
      </ul>
    </div>
    <ul id="service-card__list--controller">
      <li @click="selectService(service)" :aria-label="`${service.id}-control`" class="service-card__control"
        :class="`${service.id}-control`" v-for="service in services" :key="service.id">
        <button type="button" :title="service.name" class="service-card__control--btn"
          :class="{ 'service-card__control--btn-selected': service.selected }">
        </button>
      </li>
    </ul>
  </div>
</template>
<style scoped>
#service-card__list--wrapper {
  width: 100%;
  height: auto;
  overflow-x: hidden;
}

#service-card__list {
  display: flex;
  gap: var(--dodobank-gap-24);

  list-style-type: none;
  padding-left: 0;
  margin-left: 0;
  max-width: 100%;

  transition: all cubic-bezier(0.95, 0.05, 0.795, 0.035) 0.5s;
}

.service-card {
  width: 25%;
  min-width: 325px;
}


.service-card__image,
.service-card__image img {
  width: 100%;
  max-width: 100%;
  border-radius: var(--dodobank-image-radius);

}

.service-card__image {
  min-height: 250px;
  position: relative;
}

.service-card__image img {
  object-fit: cover;
  position: absolute;
  height: 100%;
}


.service-card__inner-box {
  display: block;
  position: relative;
}

.service-card-icon {
  position: absolute;
  bottom: 0;
  right: 0;
  z-index: 5;
  height: 6.0rem;
  width: 6.0rem;
  display: flex;
  align-items: center;
  justify-content: center;

  padding: var(--dodobank-gap-16);
  background-color: var(--dodobank-color-white);
  color: var(--dodobank-color-primary);
  border-top-left-radius: 50%;
}

.service-card-icon a {
  text-decoration: none;
  border-radius: 100%;
  border: 1px solid var(--dodobank-color-primary);
  height: 4.0rem;
  width: 4.0rem;
  display: flex;
  align-items: center;
  justify-content: center;

  transition: all .7s cubic-bezier(0.075, 0.82, 0.165, 1);
}

.service-card-icon i.bi::before {
  display: block;
  font-size: 2.0rem;
  color: var(--dodobank-color-primary);
  transition: all .7s cubic-bezier(0.075, 0.82, 0.165, 1);
}

.service-card-icon::before {
  position: absolute;
  content: "";
  bottom: 0;
  left: -1.25rem;
  background: transparent;
  width: 1.25rem;
  height: 1.25rem;
  border-bottom-right-radius: 1.25rem;
  box-shadow: 0.313rem 0.313rem 0 0.313rem var(--dodobank-color-white);
}

.service-card-icon::after {
  position: absolute;
  content: "";
  top: -1.25rem;
  right: 0;
  background: transparent;
  width: 1.25rem;
  height: 1.25rem;
  border-bottom-right-radius: 1.25rem;
  box-shadow: 0.313rem 0.313rem 0 0.313rem var(--dodobank-color-white);
}

.service-card-icon:hover a {
  background-color: var(--dodobank-color-primary);
}


.service-card-icon:hover i.bi::before {
  color: var(--dodobank-color-white);
}

#service-card__list--controller {
  padding-left: 0;
  margin-left: 0;
  list-style-type: none;
  display: flex;
  justify-content: center;
  align-items: center;
  gap: var(--dodobank-gap-16);
}

.service-card__control--btn {
  height: 1.0rem;
  width: 2.5rem;
  background-color: hsla(160, 96%, 18%, 0.2);
  border-radius: 2.5rem;
  cursor: pointer;
  box-sizing: border-box;

  border: none;
}

.service-card__control--btn-selected {
  background-color: var(--dodobank-color-primary);
}
</style>
