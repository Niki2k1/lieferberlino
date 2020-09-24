import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    location: {
      coords: {
        latitude: 0,
        longitude: 0
      }
    }
  },
  mutations: {
    setLocation (state, val) {
      fetch(`http://localhost:5000/geo/mapAddress?lat=${val.coords.latitude}&lon=${val.coords.longitude}`).then((response) => {
        response.json().then((response) => {
          const location = {
            coords: {
              latitude: val.coords.latitude,
              longitude: val.coords.longitude
            },
            address: response.address
          }

          state.location = location
        })
      })
    }
  },
  actions: {
    async getCurrentLocation ({ commit }) {
      navigator.geolocation.getCurrentPosition((location) => {
        commit('setLocation', location)
      })
    }
  },
  modules: {
  }
})
