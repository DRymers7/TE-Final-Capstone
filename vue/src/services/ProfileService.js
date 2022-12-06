import axios from 'axios';
  

export default {

  setBaseInsulin( insulinLevel, user) {
    return axios.put('/insulin', insulinLevel, user)
  },

  getBaseInsulin(user) {
    return axios.get('/insulin', user)
  },


  setInsulinStrength( insulinStrength, user){
    return axios.put('/insulin', insulinStrength, user )
  },

  getInsulinStrength (user) {
    return axios.get('/insulin', user)
  }



}