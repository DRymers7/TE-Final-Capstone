<template>
    <div>
        <h1>Profile Setup</h1>
    <div class="profile">
        
         <form v-on:submit.prevent>
    <div class="profile-form-element">
      <label for="baseInsulin">Base Insulin</label>
      <input name="base_insulin" type="text" v-model="baseInsulin" />
    </div>
   
    <div class="actions">
      <button type="submit" v-on:click="setBaseInsulin()">Update Base Insulin</button>
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
            baseInsulin: ""
        }

    },
    methods: {
        setBaseInsulin(){
            const baseInsulin = {
            user: this.userId, insulinLevel: this.BaseInsulin };
            ProfileService.setBaseInsulin(baseInsulin.userId, baseInsulin);

            }
        }



    }
</script>

<style>

    h1{
        display: flex;
        align-items: center;
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
