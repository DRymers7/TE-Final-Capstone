import axios from "axios";

export default {
  getUserBloodSugarReadings() {
    return axios.get("/blood-sugars");
  },

  getPrediction() {
    return axios.get("/predictions")
  }
};
