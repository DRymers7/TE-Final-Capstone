import axios from 'axios';
  

export default {
    postNewMeal(Meal) {
        return axios.post('/', Meal) 
      },
}