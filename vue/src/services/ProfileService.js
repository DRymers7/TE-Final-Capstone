import axios from 'axios';
  

export default {

  setBaseInsulin( insulinLevel) {
    return axios.put('/insulin', insulinLevel)
  },

  postNewInsulin(insulin, insulinId) {
    return axios.post('/insulin', insulin, insulinId )
  },

  getBaseInsulin(user) {
    return axios.get('/insulin', user)
  },

  setInsulinStrength( insulinStrength, user){
    return axios.put('/insulin', insulinStrength, user )
  },

  getInsulinStrength (user) {
    return axios.get('/insulin', user)
  },

  postNewBloodSugar(bloodSugar) {
    return axios.post('/blood-sugars', bloodSugar)
  }

}