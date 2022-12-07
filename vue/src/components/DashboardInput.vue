<template>
<div>
  <div id=reading_form>
    <div>
    <h2>How Much Insulin Do I Need?</h2>
    </div>
   <div>
     <form id=insulin-reader class="readings-form" v-on:submit.prevent="">
        <div class="dashboard-reader-form-element">
                <label for="blood_sugar">Insert Current Blood Sugar: </label>
                <input placeholder="Insert Current Blood Sugar" name="blood_sugar_input" type="text" v-model="Reading.bloodSugar" />
        <h2></h2>
                <label for="carb_count">Insert Amount of Carbs: </label>
                <input placeholder="Enter Insulin to Carb Ratio" name="carb_input" type="text" v-model="Reading.carbs" />
           <div class="actions">
      <button type="submit" v-on:click="postNewReading(), resetForm()" >Submit</button>
        </div>
    </div>
    </form>
  </div>
  </div>

  <div class = "table">
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
      <td> Apple </td>
      <td> 100 </td>
      <td> Slow-Acting </td>
      <td> 100ul </td>
      <td> 5ml </td>
      </tr>
</table>
  </div>
</div>
</template>

<script>
import DashboardService from '../services/DashboardService';
export default {

    name:"dashboard",
    data(){
      return {
        Meal: {
          Carbs: "",
          Food: "",
          Meal_Time: "",
        },

        Reading: {
          
        }

      }
  },
  methods: {

    postNewReading() {

      DashboardService.postNewReading(this.Reading)
                  .then(response => {
                if (response.status==200){
                   this.resetForm();
                } else {
                    alert("unexpected response returned: ");
      }
    })
  },

   resetForm(){
            this.Reading = {};
        }
}

}
</script>

<style>
  table, th, td {
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