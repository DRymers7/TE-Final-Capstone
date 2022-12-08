import axios from "axios";

export default {
  getInsulinBrands() {
    return axios.get("/insulin-info");
  },

  getAllUserInsulin() {
    return axios.get("filler");
  },
};
