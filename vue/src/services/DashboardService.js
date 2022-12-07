import axios from 'axios';
export default {
    postNewReading(reading) {
        return axios.post('/blood-sugars',reading)
      },
    postNewMeal(meal) {
      return axios.post('/meals', meal)
    },
    getDose() {
      return axios.get('/dose')
    }
}