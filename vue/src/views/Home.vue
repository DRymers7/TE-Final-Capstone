<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <h2>Set Base Insulin Level</h2>
    <ProfileService />
    
  </div>
</template>



<script>

import ProfileService from '../services/ProfileService';


export default {
  name: "home",
  components: {
    ProfileService
  }

  };
</script>
