<template>

    <div>
     <h1>Health Setup</h1>
    <div class="profile">
    <form id=baseInsulin v-on:submit.prevent="setBaseInsulin">
    <div class="profile-baseline-form-element">
      <label for="baseInsulin">Base Insulin</label>
      <input placeholder="Enter Base Insulin Level" name="base_insulin" type="text" v-model="BaseInsulin.baseInsulin" />
    </div>
    <div class="actions">
      <button type="submit" v-on:click="setBaseInsulin()">Update Profile</button>
    </div>
  </form>
  </div>




  <div>
      <h2>My Insulin Details</h2>
  </div>
 
     <form id=insulin class="profile" v-on:submit.prevent="postNewInsulin">
        <div class="profile-insulin-form-element">
        <h2>Insulin Name</h2>
        <select class="profile" v-model="Insulin.name">
            <option value=""></option>
        </select>
        <h2>Insulin Ratio</h2>
                <label for="baseInsulin">Insulin Ratio</label>
                <input placeholder="Enter Insulin to Carb Ratio" name="base_insulin" type="text" v-model="Insulin.insulinRation" />
           <h2>Insulin Type</h2>
            <select class="profile" v-model="Insulin.insulinType">
                <option disabled value="">Select</option>
                <option>Rapid-Acting</option>
                <option>Short-Acting</option>
                <option>Intermediate-Acting</option>
                <option>Long-Acting</option>
                <option>Pre-Mixed</option>
                
            </select>
          <h2>Insulin Strength</h2>
            <select class="profile" v-model="Insulin.insulinStrength">
                <option disabled value="">Select</option>
                <option>U-100</option>
                <option>U-200</option>
                <option>U-300</option>
                <option>U-400</option>
                <option>U-500</option>
            </select>
               <div class="actions">
      <button type="submit" v-on:click="postNewInsulin(),resetForm()">Update Profile</button>
        </div>
      
    </div>
    </form>
  </div>
    
</template>

<script>
import ProfileService from '../services/ProfileService';
export default {

    name:"profile",
    data(){
        return{
            
            BaseInsulin: {
             insulinId: "",
             baseLevel: "",
             averageLevel: "",
             timeSinceLastDose: "",
             insulinType: "",
             insulinStrength: "",
             insulinRation: ""
            },


            Insulin: {

                halfLife: "",
                onset: "",
                peak: "",
                duration: "",
                timeSinceLastDose:"",
                 insulinId: "",
                baseLevel: "",
                averageLevel: "",
                insulinType: "",
                insulinStrength: "",
                insulinRation: ""
            },
            insulinId: 0
        }

    },
    methods: {
        setBaseInsulin(){
            ProfileService.setBaseInsulin(this.BaseInsulin.baseLevel)
            .then((response) => {
                if (response.status <300){
                    this.$router.push({
                        name: "home",
                    })
                }
            }).catch (error => console.error(error));

            },
        
        setInsulinStrength(){
            const insulinStrength = {
            user: this.userId, insulinStrength: this.BaseInsulin.insulinStrength};
            ProfileService.setInsulinStrength(insulinStrength);
            },
        postNewInsulin(){
            this.Insulin.insulinId = this.insulinId;

            ProfileService.postNewInsulin(this.Insulin, this.insulinId)
            .then(response => {
                if (response.status==200){
                   this.resetForm();
                } else {
                    alert("unexpected response returned: ");
                }
            })

        },

        resetForm(){
            this.Insulin = {};
        }
    }

 
        }
</script>

<style>



    button {

    position: relative;
    display: inline-block;
    padding: 10px 20px;
    font-size: 16px;
    text-decoration: none;
    text-transform: uppercase;
    overflow: hidden;
    margin-top: 40px;
    letter-spacing: 4px;
}

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
        font-weight: bold;
        font-size: 1.5rem;
        
    }






</style>


--cadet: #4f6d7aff;
--columbia-blue: #c0d6dfff;
--alice-blue: #dbe9eeff;
--blue-yonder: #4a6fa5ff;
--blue-sapphire: #166088ff;

