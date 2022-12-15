import axios from "axios";

export default {
  getUserBloodSugarReadings() {
    return axios.get("/blood-sugars");
  },

  getPredictions() {
    return axios.get("/predictions");
  }
};
