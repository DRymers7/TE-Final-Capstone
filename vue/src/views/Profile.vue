<template>
  <div class="profile">
    <h1>Profile Set Up</h1>

    <ProfileService />
    <Profile />
  </div>
</template>

<script>
import ProfileService from "../services/ProfileService";
import Profile from "../components/Profile";

export default {
  components: {
    ProfileService,
    Profile,
  },
};
</script>
