import axios from 'axios';

const insulinTrackerApi = axios.create({
  baseURL: "http://localhost:8081"
});

export default {


  login(user) {
    return insulinTrackerApi.post('/login', user)
  },

  register(user) {
    return insulinTrackerApi.post('/register', user)
  }

}
