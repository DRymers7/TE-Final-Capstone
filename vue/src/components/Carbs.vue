<template>
  <div id="carb-table-container">
    <div class="table-title">
      <h3>{{ tableName }}</h3>
    </div>
    <table id="carbstyled-table">
      <thead>
        <tr>
          <th>Meal</th>
          <th>Carbs</th>
        </tr>
      </thead>
      <tbody v-for="meal in meals" :key="meal.mealId">
        <td>{{ meal.food }}</td>
        <td>{{ meal.carbs }}</td>
      </tbody>
      <tr>
        <td>Total Carbs</td>
        <td>{{ getTotalCarbs() }}</td>
      </tr>
    </table>

    <div id="add_button" tabindex="0">
      <input
        type="text"
        v-model="searchQuery"
        placeholder="What did you eat?"
      />
      <button id="addMeal" type="submit" v-on:click.prevent="getCarbCount()">
        Add Meal
      </button>
    </div>
  </div>
</template>

<script>
import MealService from "../services/MealService.js";
export default {
  tableName: "Carbs Tracker",
  data() {
    return {
      meal: {
        mealId: "",
        carbs: "",
        food: "",
        glycemicIndex: "",
        mealTime: "",
      },
      totalCarbs: 0,
      totalMeals: 0,
      averageGI: 0,
      meals: [],
      searchQuery: "",
    };
  },
  methods: {
    getCarbCount() {
      MealService.getCarbCount(this.searchQuery)
        .then((response) => {
          this.meals = response.data;
          this.resetQuery();
          this.getUserMeals();
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getTotalCarbs() {
      let totalCarbs = 0;
      this.meals.forEach((meal) => {
        totalCarbs += meal.carbs;
      });
      return totalCarbs;
    },
    resetQuery() {
      this.searchQuery = "";
    },
  },
  created() {
    console.log("AHHAHAHAH")
    MealService.getUserMeals()
      .then((response) => {
        this.meals = response.data;
      })
      .catch((error) => {
        console.log(error);
      });
    console.log(this.meals);
  }
  
};
</script>

<style>
#carb-table-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    margin: 0 auto;
    width: 100%;
    height: 100%;
    background-color: #f5f5f5;
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
#carbstyled-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
#carbstyled-table thead tr {
    background-color: #6cd0ff;
    color: #d8d8d8;
    text-align: left;
}
#carbstyled-table th,
#carbstyled-table td {
    padding: 12px 15px;
}
#carbstyled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

#carbstyled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

#carbstyled-table tbody tr:last-of-type {
    border-bottom: 2px solid #6cd0ff;
}

div input {
    width: 100%;
    padding: 10px 0;
    font-size: 16px;
    margin-bottom: 30px;
    background: rgb(156, 156, 156);
    border: none;
    border-bottom: 1px solid #fff;
    outline: none;
    color: rgb(0, 0, 0);
}
button {
    background-color: #84bce2;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}
</style>
