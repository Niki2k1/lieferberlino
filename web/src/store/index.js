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
      fetch(`https://us1.locationiq.com/v1/reverse.php?key=pk.b18db41a3064a9b1769bf1266de93462&lat=${val.coords.latitude}&lon=${val.coords.longitude}&format=json`).then((response) => {
        response.json().then((response) => {
          console.log(response)
          const location = {
            coords: {
              latitude: val.coords.latitude,
              longitude: val.coords.longitude
            },
            address: response.display_name
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
