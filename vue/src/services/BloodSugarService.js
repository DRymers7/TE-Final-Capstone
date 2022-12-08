import axios from "axios";

export default {
  getUserBloodSugarReadings() {
    return axios.get("/blood-sugar");
  },
};
