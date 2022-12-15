import axios from "axios";

export default {
  postNewImage(imageData) {
    return axios.post("/userdata", imageData);
  }
}
