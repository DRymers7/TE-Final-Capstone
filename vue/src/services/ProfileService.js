import axios from 'axios';

export default {

  setBaseInsulin(user) {
    return axios.put('/profile/base-insulin', user)
  },

  getBaseInsulin() {
    return axios.get('/profile/base-insulin')
  }

}