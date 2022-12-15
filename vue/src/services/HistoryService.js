import axios from "axios";
export default {
  getUserBloodSugarOneDay() {
    return axios.get("/blood-sugars/one-day");
  },
  getUserBloodSugarThreeDays() {
    return axios.get("/blood-sugars/three-days");
  },
  getUserBloodSugarOneWeek() {
    return axios.get("/blood-sugars/one-week");
  },
  getUserBloodSugarTwoWeeks() {
    return axios.get("/blood-sugars/two-weeks");
  },

  getUserBloodSugarOneMonth() {
    return axios.get("/blood-sugars/one-month");
  },
  getUserHistoryOneMonth() {
    return axios.get("/average/one-month");
  },
};
