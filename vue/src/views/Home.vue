<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <ProfileService />
    <Chart />
  </div>
</template>

<script>
import Chart from '../components/Chart.vue';
import ProfileService from "../services/ProfileService";


export default {
  name: "home",
  components: {
    ProfileService,
    Chart,
   

  },
};
</script>
