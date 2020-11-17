import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import SearchResults from '../views/SearchResults.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/results',
    name: 'SearchResults',
    component: SearchResults
  }
]

const router = new VueRouter({
  base: process.env.BASE_URL,
  routes
})

export default router
