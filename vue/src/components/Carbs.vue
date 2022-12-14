<template>
<div id="table-container-carbs">
    <div class="table-title">
        <h3>{{tableName}}</h3>
    </div>
    <table class="styled-table">
        <thead>
            <tr>
                <th>Meal</th>
                <th>Carbs</th>
            </tr>
        </thead>
        <tbody v-for="meal in meals" :key="meal.mealId">
            <td>{{meal.food}}</td>
            <td>{{meal.carbs}}</td>
        </tbody>
            <tr>
                <td>Total Carbs</td>
                <td>{{getTotalCarbs()}}</td>
            </tr>
    </table>
    <div id="add_button" tabindex="0">
        <input type="text" v-model="searchQuery" placeholder="What did you eat?" />
        <button id="addMeal" type="submit" v-on:click.prevent="getCarbCount()">Add Meal</button>
    </div>

</div>
</template>
    
<script>
import MealService from '../services/MealService.js'
export default {
    tableName: 'Carbs Tracker',
    data() {
        return {
            meal: {
                mealId: '',
                carbs: '',
                food: '',
                glycemicIndex: '',
                mealTime: ''

            },
            totalCarbs: 0,
            totalMeals: 0,
            averageGI: 0,
            meals: [],
            searchQuery: ''
        }
    },
    methods: {
        getCarbCount() {
            MealService.getCarbCount(this.searchQuery)
                .then((response) => {
                    this.meals = response.data
                    this.resetQuery();
                }).catch((error) => {
                    console.log(error)
                })
        },
        getTotalCarbs() {
            let totalCarbs = 0
            this.meals.forEach(meal => {
                totalCarbs += meal.carbs
            })
            return totalCarbs
        },
        resetQuery() {
            this.searchQuery = ''
        }
        
    },
    created() {
        MealService.getUserMeals()
            .then((response) => {
                this.meals = response.data
            }).catch((error) => {
                console.log(error);
            })
            console.log(this.meals);
            
    },

}
</script>
    
<style>
/* #table-container-carbs {
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
.styled-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}
.styled-table th,
.styled-table td {
    padding: 12px 15px;
}
.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}

div input {
    width: 100%;
    padding: 10px 0;
    font-size: 16px;
    margin-bottom: 30px;
    color: #fff;
    background: transparent;
    border: none;
    border-bottom: 1px solid #fff;
    outline: none;
}
button {
    background-color: #009879;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
} */

</style>