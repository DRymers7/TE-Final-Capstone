<template>
    <div>
        <h1>Profile Setup</h1>
    <div class="profile">

         <form v-on:submit.prevent>
    <div class="profile-form-element">
      <label for="baseInsulin">Base Insulin</label>
      <input placeholder="Enter Base Insulin Level" name="base_insulin" type="text" v-model="baseInsulin" />
    </div>

<h2>Type of Insulin</h2>

<select class="profile" v-model="insulinType">
  <option disabled value="">Select</option>
  <option>Fast Acting</option>
  <option>Slow Acting</option>
</select>

<h2>Insulin Strength</h2>
<select class="profile" v-model="strength">
  <option disabled value="">Select</option>
  <option>U-100</option>
  <option>U-200</option>
  <option>U-300</option>
  <option>U-400</option>
  <option>U-500</option>
</select>



 
    <div class="actions">
      <button type="submit" v-on:click="setBaseInsulin()">Update Profile</button>
    </div>
  </form>
    </div>



    </div>    
</template>

<script>
import ProfileService from '../services/ProfileService';
export default {

    name:"profile",
    data(){
        return{
            userID: "",
            baseInsulin: "",
            insulinType: "",
            strength: ""
        }

    },
    methods: {
        setBaseInsulin(){
            const baseInsulin = {
            user: this.userId, insulinLevel: this.BaseInsulin };
            ProfileService.setBaseInsulin(baseInsulin);

            }
        },
        setInsulinStrength(){
            const insulinStrength = {
            user: this.userId, strength: this.strength};
            ProfileService.setInsulinStrength(insulinStrength);
            }
        }
</script>

<style>

    h1{
        display: flex;
        align-items: center;
        justify-content: center;
    }

    h2{
        display: flex;
        justify-content: center;
    }

    .profile{
        display: flex;
        align-items: center;
        justify-content: center;
        box-shadow: 0 2px 8px;
        margin: 3rem auto;
        border-radius: 10px;
        padding: 1rem;
        text-align: center;
        width: 50%;
        max-width: 40rem;

    }
    .profile-form-element{
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
