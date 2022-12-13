<template>
  <div>
    <div id="reading_form">
      <div>
        <h2>How Much Insulin Do I Need?</h2>
      </div>
      <div>
        <form
          id="blood-sugar-reading-form"
          class="readings-form"
          v-on:submit.prevent=""
        >
          <div class="dashboard-reader-form-element">
            <label for="blood_sugar">Insert Current Blood Sugar: </label>
            <input
              placeholder="Insert Current Blood Sugar"
              name="blood_sugar_input"
              type="number"
              v-model="Reading.inputLevel"
            />
            <div class="actions">
              <button type="submit" v-on:click="postNewReading()">
                Submit
              </button>
              <h2>{{ Dose.CorrectionalDoseLow }}</h2>
              <h2>{{ Dose.CorrectionalDoseHigh }}</h2>
            </div>
          </div>
        </form>
      </div>
      <div>
        <form id="meal-form" class="readings-form" v-on:submit.prevent="">
          <div class="dashboard-reader-form-element">
            <label for="carb_count">Insert Amount of Carbs: </label>
            <input
              placeholder="Input Carbs Eaten"
              name="carb_input"
              type="number"
              v-model="Meal.carbs"
            />
            <h2></h2>
            <label for="food_eaten">Describe Meal Eaten: </label>
            <input
              placeholder="What did you eat?"
              name="food_input"
              type="text"
              v-model="Meal.food"
            />
            <h2></h2>
            <label for="glycemic_index">GlycemicIndex: </label>
            <input
              placeholder=""
              name="glycemic_index_input"
              type="number"
              v-model="Meal.glycemicIndex"
            />
            <div class="actions">
              <button type="submit" v-on:click="postNewMeal()">Submit</button>
            </div>
            <div>
              <button type="submit">Get Dose</button>
            </div>
          </div>
        </form>
      </div>
    </div>
    <div class="table">
      <table>
        <thead>
          <tr>
            <th>Meal</th>
            <th>Blood Sugar Level</th>
            <th>Insulin Type</th>
            <th>Insulin Strength</th>
            <th>Amount of Insulin Used</th>
          </tr>
        </thead>
        <tr>
          <td>Apple</td>
          <td>100</td>
          <td>Slow-Acting</td>
          <td>100ul</td>
          <td>5ml</td>
        </tr>
      </table>
    </div>
  </div>
</template>
<script>
import { init } from "emailjs-com";
init("");
import DashboardService from "../services/DashboardService";
import BloodSugarService from "../services/BloodSugarService";
import ProfileService from "../services/ProfileService";
import emailjs from "emailjs-com";
export default {
  name: "dashboard",
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
      Meal: {
        carbs: "",
        food: "",
        glycemicIndex: "",
        mealTime: "",
      },
      Reading: {
        targetLow: "",
        targetHigh: "",
        inputLevel: "",
        lastMeasurement: "",
      },
      Dose: "",
      Readings: [],
      CarbCount: "",
    };
  },
  methods: {
    sendEmail() {
      //will need to substitute values before we post to github, but the values are (service id, template, id, template params and public key)
      emailjs
        .send(
          "service_nwrb0fr",
          "template_c6kunah",
          {
            from_name: "test",
            to_name: "test",
            user_email: this.userData.username,
            message: "test",
          },
          "7njRAw8N8MgG_lqIQ"
        )
        .then(
          function(response) {
            console.log("SUCCESS!", response.status, response.text);
          },
          function(error) {
            console.log("FAILED...", error);
          }
        );
    },
    getUserData() {
      ProfileService.getUserData().then((response) => {
        if (response.status == 200) {
          this.userData = response.data;
        } else {
          console.log("unexpected response")
        }
      })
    },
    getDose() {
      DashboardService.getDose().then((response) => {
        if (response.status == 200) {
          this.Dose = response.data;
        }
      });
    },
    postNewReading() {
      // this.findUsersTargetHighAndLow();
      DashboardService.postNewReading(this.Reading).then((response) => {
        if (response.status == 200) {
          this.resetForm();
          this.getDose();
          this.checkForAlert();
        } else {
          alert("unexpected response returned: ");
        }
      });
    },
    postNewMeal() {
      DashboardService.postNewReading(this.Meal).then((response) => {
        if (response.status == 200) {
          this.resetForm();
        } else {
          alert("unexpected response returned: ");
        }
      });
    },
    resetForm() {
      this.Reading = {};
      this.Meal = {};
    },
    //order by clause in server needed
    checkForAlert() {
      BloodSugarService.getUserBloodSugarReadings()
      .then((response) => {
        this.Readings = response.data;
      })
      .catch((error) => console.error(error));

      const mostRecentReading = this.Readings[0];
      console.log(mostRecentReading);
      if (
        mostRecentReading.inputLevel > mostRecentReading.targetHigh * 0.8 ||
        mostRecentReading.inputLevel < mostRecentReading.targetLow * 1.2
      ) {
        alert(
          "Your blood sugar is within 20% of your target range. Please plan on a correctional dose or snack."
        );
        ProfileService.getUserData()
        this.sendEmail(); // Uncomment when we want to present
      }
    }
    
  },
  created() {
    BloodSugarService.getUserBloodSugarReadings()
      .then((response) => {
        this.Readings = response.data;
      })
      .catch((error) => console.error(error));
  },
  beforeMount() {
    this.Readings.forEach((reading) => {
      if (reading.targetLow !== 0 || reading.targetHigh !== 0) {
        this.Reading.targetLow = reading.targetLow;
        this.Reading.targetHigh = reading.targetHigh;
      }
    });
  },
};
</script>
<style>
table,
th,
td {
  border: 1px solid black;
}
.readings-form {
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
</style>
