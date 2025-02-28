<script setup lang="ts">
import HomeImage from '@/components/home/HomeImage.vue';
import HomeImageSupportingText from '@/components/home/HomeImageSupportingText.vue';
import HomeAuthSection from '@/components/home/HomeAuthSection.vue';
import HomeServicesHeader from '@/components/home/HomeServicesHeader.vue';
import HomeServicesList from '@/components/home/HomeServicesList.vue';

</script>

<template>
  <div class="container-fluid">
    <div class="container">
      <section id="app-home-presentation">
        <div class="row">
          <div class="col col-sm-9">
            <div class="row">
              <div class="col">
                <HomeImage />
              </div>
              <div class="col">
                <HomeImageSupportingText />
              </div>
            </div>
          </div>
          <div class="col">
            <HomeAuthSection />
          </div>
        </div>
      </section>
    </div>
  </div>
  <div class="container-fluid">
    <div class="container">
      <section id="app-home-services" class="text-center">
        <div class="row py-lg-5">
          <div class="col-lg-8 col-md-8 mx-auto">
            <HomeServicesHeader />
          </div>
        </div>
      </section>
    </div>
    <HomeServicesList/>
  </div>
</template>
<style scoped>
#app-home-presentation {
  margin-top: 2rem;
  border-radius: 1rem;
}
</style>