<template>
  <div class="profile">
    <h1>Profile Set Up</h1>

    <ProfileService />
    <Profile />
    <ProfilePicture />
  </div>
</template>

<script>
import ProfileService from "../services/ProfileService.js";
import Profile from "../components/Profile.vue";
import ProfilePicture from "../components/ProfilePicture.vue"

export default {
  components: {
    ProfileService,
    Profile,
    ProfilePicture
  },
};
</script>
