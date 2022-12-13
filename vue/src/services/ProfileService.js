import axios from "axios";

export default {
  postNewInsulin(insulin, insulinId) {
    return axios.post("/insulin", insulin, insulinId);
  },

  updateNewInsulin(insulin, insulinId) {
    return axios.put("/insulin", insulin, insulinId);
  },

  postNewBloodSugar(bloodSugar) {
    return axios.post("/blood-sugars", bloodSugar);
  },

  updateBloodSugar(bloodSugar) {
    return axios.put("/blood-sugars", bloodSugar);
  },

  getUserData() {
    return axios.get("/userdata")
  }
};
