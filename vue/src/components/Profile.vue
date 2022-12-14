<template>
  <div>
    <div class="profile-picture">
        //call profile picture here
      </div>
    <h1>Health Setup</h1>
    <div class="profile">
      <form id="health" v-on:submit.prevent="setHealth">
        <div class="profile-baseline-form-element">
          <label for=""></label>
          <input placeholder="Enter Age" type="number" />
        </div>
        <div class="actions">
          <button type="submit" v-on:click="setHealth()">Update Profile</button>
        </div>
      </form>
    </div>
    <div>
      <h2>My Insulin Details</h2>
    </div>
    <div>
      <form id="insulin" class="profile">
        <div class="profile-insulin-form-element">
          <h2>Base Insulin</h2>
          <label for="baseInsulin">Base Insulin: </label>
          <input
            placeholder="Enter Base Insulin Level"
            name="base_insulin"
            type="number"
            v-model="Insulin.baseLevel"
          />
          <h2>Insulin Name</h2>
          <select class="profile" v-model="Insulin.insulinBrandName" required>
            <option v-for="name in brandNames" v-bind:key="name">{{
              name
            }}</option>
          </select>
          <h2>Insulin Ratio</h2>
          <label for="baseInsulin">Insulin Ratio: </label>
          <input
            placeholder="Enter Insulin to Carb Ratio"
            name="base_insulin"
            type="number"
            step="0.1"
            v-model="Insulin.insulinRatio"
          />
          <h2>Insulin Type</h2>
          <select class="profile" v-model="Insulin.insulinType" required>
            <option disabled value="">Select</option>
            <option>Rapid-Acting</option>
            <option>Short-Acting</option>
            <option>Intermediate-Acting</option>
            <option>Long-Acting</option>
            <option>Pre-Mixed</option>
          </select>
          <h2>Insulin Strength</h2>
          <select class="profile" v-model="Insulin.insulinStrength" required>
            <option disabled value="">Select</option>
            <option>U-100</option>
            <option>U-200</option>
            <option>U-300</option>
            <option>U-400</option>
            <option>U-500</option>
          </select>
          <div class="actions">
            <button type="submit" v-on:click.prevent="postNewInsulin()">
              Update Profile
            </button>
          </div>
        </div>
      </form>
    </div>
    <div>
      <h2>My Blood Sugar Range</h2>
    </div>
    <form id="blood_sugar" class="profile">
      <div>
        <h2>Target Blood Sugar Range</h2>
        <label for="target_low">Target Low: </label>
        <input
          placeholder="Enter Target Low"
          name="target_low"
          type="number"
          v-model.number="Blood_Sugar.targetLow"
        />
        <br />
        <h2></h2>
        <label for="target_high">Target High: </label>
        <input
          placeholder="Enter Target High"
          name="target_high"
          type="number"
          v-model.number="Blood_Sugar.targetHigh"
        />
        <br />
        <button type="submit" v-on:click.prevent="postNewBloodSugar()">
          Update Blood Sugar
        </button>
      </div>
    </form>
  </div>
</template>
<script>
import ProfileService from "../services/ProfileService";
import InsulinService from "../services/InsulinService";
export default {
  name: "profile",
  data() {
    return {
      userData: {
        userId: "",
        a1c: "",
        fastingGlucose: "",
        diabetesType: "",
        userAge: "",
        lastUpdated: "",
        weight: "",
        height: "",
        activityLevel: "",
        emergencyContact1: "",
        emergencyContact2: "",
        username: "",
        profilePic: ""
      },
      BaseInsulin: {
        insulinId: "",
        baseLevel: "",
        averageLevel: "",
        timeSinceLastDose: "",
        insulinBrandName: "",
        insulinStrength: "",
        insulinRatio: "",
      },
      Insulin: {
        halfLife: "",
        onset: "",
        peak: "",
        duration: "",
        timeSinceLastDose: "",
        insulinId: "",
        baseLevel: "",
        averageLevel: "",
        insulinType: "",
        insulinStrength: "",
        insulinRatio: "",
        insulinBrandName: "",
      },
      Blood_Sugar: {
        targetLow: "",
        targetHigh: "",
      },
      insulinId: 0,
      brandNames: "",
    };
  },
  methods: {

    getNewUserData() {
      ProfileService.getUserData() 
      },

    postNewInsulin() {
      ProfileService.postNewInsulin(this.Insulin, this.Insulin.insulinId)
        .then((response) => {
          if (response.status == 200) {
            this.resetForm();
          }
        })
        .catch((error) => console.error(error));
    },

    updateNewBloodSugar() {
      ProfileService.updateBloodSugar(this.Blood_Sugar)
        .then((response) => {
          if (response.status == 200) {
            this.resetForm();
          }
        })
        .catch((error) => console.error(error));
    },

    postNewBloodSugar() {
      ProfileService.postNewBloodSugar(this.Blood_Sugar).then((response) => {
        if (response.status == 200) {
          this.resetBloodSugarForm();
        } else {
          alert("unexpected response returned: ");
        }
      });
    },
    
    resetForm() {
      this.Insulin = {};
    },
    resetBloodSugarForm() {
      this.Blood_Sugar = {};
    },
  },
  created() {
    InsulinService.getInsulinBrands()
      .then((response) => {
        this.brandNames = response.data;
      })
      .catch((error) => console.error(error));
  },
};
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
h1 {
  display: flex;
  align-items: center;
  justify-content: center;
}
h2 {
  display: flex;
  justify-content: center;
}
.profile {
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
.profile-form-element {
  display: flex;
  font-weight: bold;
  font-size: 1.5rem;
}
</style>
--cadet: #4f6d7aff; --columbia-blue: #c0d6dfff; --alice-blue: #dbe9eeff;
--blue-yonder: #4a6fa5ff; --blue-sapphire: #166088ff;
