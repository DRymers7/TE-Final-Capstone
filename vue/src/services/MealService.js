import axios from "axios";

export default {
  getCarbCount(query) {
    return axios.get(`/meals/info/${query}`);
  },
  getUserMeals() {
    return axios.get("/meals");
  }
};
