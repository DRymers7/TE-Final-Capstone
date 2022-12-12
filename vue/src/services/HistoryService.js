import axios from "axios";
export default {
    
  getUserHistoryOneDay() {
      return axios.get("/average/one-day");
  },
  getUserHistoryThreeDays() {
      return axios.get("/average/three-days");
  },
  getUserHistoryOneWeek() {
      return axios.get("/average/one-week");
  },
  getUserHistoryTwoWeeks() {
      return axios.get("/average/two-weeks");
  },
  getUserHistoryOneMonth() {
      return axios.get("/average/one-month");
  }

};
