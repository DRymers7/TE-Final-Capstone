<template>
    <div>
    <div class="profile">
        <h1>Profile Setup</h1>
    </div>    


   
  </div>
</template>

<script>
import ProfileService from '../services/ProfileService';
export default {

    name:"profile",
    data(){

    },
    methods: {
        setBaseInsulin(){
            const baseInsulin = {user: this.userId, insulinLevel: this.BaseInsulin };
            ProfileService.setBaseInsulin(baseInsulin.userId, baseInsulin);

            }
        }



    }
</script>

<style>

</style>