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
              <button
                type="submit"
                v-on:click="postNewReading(), resetForm(), checkForAlert()"
              >
                Submit
              </button>
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
import DashboardService from "../services/DashboardService";

export default {
  name: "dashboard",
  data() {
    return {
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

      Dose: {},
    };
  },

  methods: {
    postNewReading() {
      DashboardService.postNewReading(this.Reading).then((response) => {
        if (response.status == 200) {
          this.resetForm();
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

    sendEmail() {},

    //order by clause in server need
    checkForAlert() {
      const mostRecentReading = this.$store.Readings.lastMeasurement;

      if (
        mostRecentReading.inputLevel > mostRecentReading.targetHigh * 0.8 ||
        mostRecentReading.inputLevel < mostRecentReading.targetLow * 1.2
      ) {
        return this.basicPrintAlert;
      }
    },
    basicPrintAlert() {
      console.log("you need help");
    },
  },

  created() {
    DashboardService.getDose().then((response) => {
      this.Dose = response.data;
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
