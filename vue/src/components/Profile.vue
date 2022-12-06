<template>

    <div>
        <h1>Profile Setup</h1>
    <div class="profile">
    <form v-on:submit.prevent="setBaseInsulin">
    <div class="profile-form-element">
      <label for="baseInsulin">Base Insulin</label>
      <input placeholder="Enter Base Insulin Level" name="base_insulin" type="text" v-model="userProfile.baseInsulin" />
    </div>

<h2>Type of Insulin</h2>

<select class="profile" v-model="userProfile.insulinType">
  <option disabled value="">Select</option>
  <option>Fast Acting</option>
  <option>Slow Acting</option>
</select>

<h2>Insulin Strength</h2>
<select class="profile" v-model="userProfile.strength">
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
            
            userProfile: {
             baseInsulin: "",
             insulinType: "",
             strength: ""
            }
        }

    },
    methods: {
        setBaseInsulin(){
            ProfileService.setBaseInsulin(this.userProfile)
            .then((response) => {
                if (response.status <300){
                    this.$router.push({
                        name: "home",
                    })
                }
            }).catch (error => console.error(error));

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
        background: linear-gradient(120DEG, #dbe9eeff,#35495E);
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
        font-weight: bold;
        font-size: 1.5rem;


    }
</style>


--cadet: #4f6d7aff;
--columbia-blue: #c0d6dfff;
--alice-blue: #dbe9eeff;
--blue-yonder: #4a6fa5ff;
--blue-sapphire: #166088ff;

