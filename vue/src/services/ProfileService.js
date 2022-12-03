import axios from 'axios';

export default {

  setBaseInsulin(user, insulinLevel) {
    return axios.put('/profile/base-insulin', user, insulinLevel)
  },

  getBaseInsulin() {
    return axios.get('/profile/base-insulin')
  }

}