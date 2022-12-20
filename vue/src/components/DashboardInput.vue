<template>
  <div class="body">
    <div id="reading_form">
      <div>
        <h1>How Much Insulin Do I Need?</h1>
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
              placeholder="Input Current Level"
              name="blood_sugar_input"
              type="number"
              v-model="Reading.inputLevel"
            />
            <h2></h2>
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
            <label for="glycemic_index">Glycemic Index: </label>
            <input
              placeholder="Input Glycemic Index"
              name="glycemic_index_input"
              type="number"
              v-model="Meal.glycemicIndex"
            />
            <h2></h2>
            <div class="actions">
              <button type="submit" v-on:click="postNewMeal()">Submit</button>
            </div>
            <h2></h2>
            <div class="actions">
              <button type="submit" v-on:click="getDose()">Get New Dose</button>
            </div>
            <h2>{{ Dose }}</h2>

            <!-- <div>
              <button type="submit" v-on:click="getPrediction()">Predict Blood Sugar</button>
            </div> -->
          </div>
        </form>
        <form id="prediction-form" class="readings-form" v-on:submit.prevent="">
          
            <div class="actions">
              <button type="submit" v-on:click="getPrediction()">Predict Blood Sugar</button>
            </div>
            <div>
              <h2>{{predictionData}}</h2>
            </div>
          <div>
            <h2>{{ predictionData }}</h2>
          </div>
          <!-- <div>
              <button type="submit" v-on:click="getPrediction()">Predict Blood Sugar</button>
            </div> -->
        </form>
      </div>
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
      userInputBloodSugar: "",
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
        profilePic: "",
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
      predictionData: "",
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
          "EMAIL_JS_EMAILSERVICE",
          "EMAIL_JS_TEMPLATE",
          {
            from_name: "test",
            // em1: "test",
            user_email: this.userData.username,
            message: "test",
          },
          "EMAIL_JS_KEY"
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
    sendEmailEmergency() {
      emailjs
        .send(
          "EMAIL_JS_EMAILSERVICE",
          "EMAIL_JS_TEMPLATE",
          {
            from_name: "test",
            em1: this.userData.emergencyContact1,
            user_email: this.userData.username,
            message: "test",
          },
          "EMAIL_JS_KEY"
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
          this.sendEmail();
        } else {
          console.log("unexpected response");
        }
      });
    },
    getDose() {
      DashboardService.getDose()
        .then((response) => {
          if (response.status == 200) {
            this.Dose = response.data;
            console.log(this.Dose);
          }
        })
        .then(this.checkForAlert());
    },
    postNewReading() {
      // this.findUsersTargetHighAndLow();
      DashboardService.postNewReading(this.Reading).then((response) => {
        if (response.status == 200) {
          this.getDose();
          this.getPrediction();
        } else {
          alert("unexpected response returned: ");
        }
      });
    },
    postNewMeal() {
      DashboardService.postNewReading(this.Meal).then((response) => {
        if (response.status == 200) {
          this.resetForm();
          this.getUserReadings();
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
      this.getUserReadings();
      const mostRecentReading = this.Readings[0];
      const currentSugar = this.Reading.inputLevel;
      this.resetForm();
      if (
        currentSugar > mostRecentReading.targetHigh * 0.8 ||
        currentSugar < mostRecentReading.targetLow * 1.2
      ) {
        if (
          currentSugar > mostRecentReading.targetHigh ||
          currentSugar < mostRecentReading.targetLow
        ) {
          alert(
            "Your blood sugar has exceeded your target thresholds. Your emergency contacts have been notified. Please take a correctional dose immediately or eat a snack."
          );
          this.sendEmailEmergency();
        } else {
          alert(
            "Your blood sugar is within 20% of your target range. Please plan on a correctional dose or snack."
          );
          ProfileService.getUserData();
          this.sendEmail(); // Uncomment when we want to present
        }
      }
    },
    getUserReadings() {
      BloodSugarService.getUserBloodSugarReadings()
        .then((response) => {
          this.Readings = response.data;
        })
        .catch((error) => console.error(error));
    },
    getPrediction() {
      BloodSugarService.getPredictions()
        .then((response) => {
          this.predictionData = response.data;
          console.log(this.predictionData);
          console.log("Prediction success!");
        })
        .catch((error) => console.error(error));
    },
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
  border: 2px solid whitesmoke;
  color: whitesmoke;
  margin-left: 680px;
  background-color: #181d42;
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
  color: whitesmoke;
  background-image: linear-gradient(#063053, #395873, #5c7c99);
}

h1 {
  color: #181d42;
}

.body {
  background-color: white;
}

input {
  background-color: transparent;
}

label {
  margin-right: 10px;
}

button {
  background-color: #0a3356;
  border-color: whitesmoke;
  color: whitesmoke;
}

::placeholder {
  color: whitesmoke;
}
</style>
