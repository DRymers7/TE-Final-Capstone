import axios from "axios";

export default {
  postNewReading(Reading) {
    return axios.post("/", Reading);
  },
};
