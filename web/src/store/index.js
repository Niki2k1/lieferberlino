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
    },
    shopList: []
  },
  mutations: {
    setLocation (state, val) {
      const location = {
        coords: {
          latitude: val.coords.latitude,
          longitude: val.coords.longitude
        },
        address: 'Aktuelle Position'
      }

      state.location = location
    },
    setShopList (state, val) {
      state.shopList = val
    }
  },
  actions: {
    async getCurrentLocation ({ commit }) {
      navigator.geolocation.getCurrentPosition((location) => {
        commit('setLocation', location)
      })
    },
    async getShops ({ commit }) {
      fetch('https://api.lieferberlino.de/shops/getShops').then(async (response) => {
        const shopList = await response.json()
        commit('setShopList', shopList)
      })
    }
  },
  modules: {
  }
})
