import axios from "axios";

// const insulinTrackerApi = axios.create({
//   baseURL: "http://localhost:8081"
// });

export default {
  login(user) {
    return axios.post("/login", user);
  },

  register(user) {
    return axios.post("/register", user);
  },
};
