import axios from "axios";

export default {
  getCarbCount() {
    return axios.get("/meals/info/{query}");
  },
};
